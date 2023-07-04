package com.example.demo.service.impl;


import cn.afterturn.easypoi.entity.ImageEntity;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.word.WordExportUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.LogInfoMapper;
import com.example.demo.entity.LogInfo;
import com.example.demo.entity.UserEntity;
import com.example.demo.dao.UserMapper;
import com.example.demo.service.UserService;
import com.example.demo.util.EasyPoiUtils;
import com.example.demo.vo.ExcelUser.ExportExcelLog;
import com.example.demo.vo.ExcelUser.ExportExcelUser;
import com.example.demo.vo.ExcelUser.ImportUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 用户管理业务层
 */
@Service
@DS("master")
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LogInfoMapper logInfoMapper;


    /**
     * 查询db1的用户数据
     */
    @Override
    @DS("master")
    public List<UserEntity> getUsers1() {
        return this.list();
    }

    /**
     * 查询db2的用户数据
     */
    @Override
    @DS("slave_1")
    public List<UserEntity> getUsers2() {
        return this.list();
    }


    /**
     * 根据性别查询所有用户
     *
     * @param sex 性别
     */
    @Override
    public List<UserEntity> getUsersBySex(String sex) {
        //条件构造器
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        //eq 代表“ = ”；例如 eq("sex", "男") ---> sex = '男';等同于拼接在sql语句后边的where条件。
        wrapper.eq("sex", sex);
        //将条件带入返回
        List<UserEntity> list = this.list(wrapper);
        //返回数据
//        wrapper.ge("age","11");  =>age>=11
        return list;
    }


    @Override
    public UserEntity getUserById(String id) {
        LambdaQueryWrapper<UserEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserEntity::getId, id);

        wrapper.ge(UserEntity::getAge, 11);
        return this.getOne(wrapper);
    }


    /**
     * 根据用户id修改用户信息
     *
     * @param userEntity 用户信息
     */
    @Override
    public boolean updateByUserId(UserEntity userEntity) {
        //条件构造器
        UpdateWrapper<UserEntity> wrapper = new UpdateWrapper<>();
        //传入条件
        wrapper.eq("id", userEntity.getId());
        //调用修改方法
        return this.update(userEntity, wrapper);
    }


    public boolean updateByUserId() {

        return true;
    }


    /**
     * 根据用户id修改用户信息
     */
    public List<UserEntity> getUsersByIdAndDate(Integer userId, Integer age) {
        //lambda条件构造器
        LambdaQueryWrapper<UserEntity> queryWrapper = new LambdaQueryWrapper<>();
        //传入条件
        queryWrapper.eq(UserEntity::getId, userId);
        queryWrapper.eq(UserEntity::getAge, age);
        //调用修改方法
        return this.list(queryWrapper);
    }


    /**
     * excel批量导入用户
     *
     * @param file excel文件
     */
    @Override
    public Boolean importUsers(MultipartFile file) {
        //创建一个
        ImportParams importParams = new ImportParams();
        //标题行设置为1行，默认是0，可以不设置；依实际情况设置。
        importParams.setTitleRows(1);
        // 表头设置为1行
        importParams.setHeadRows(1);
        // 第几个sheet页
        importParams.setStartSheetIndex(0);
        try {
            List<ImportUser> users = ExcelImportUtil.importExcel(file.getInputStream(), ImportUser.class, importParams);
            //批量插入
            boolean isSuccess = this.saveUsers(users);
            return isSuccess;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * 批量插入用户数据
     */
    private boolean saveUsers(List<ImportUser> users) {

        //存放user
        List<UserEntity> userList = new ArrayList<>();

        //转成user实体
        for (ImportUser user : users) {
            //验空
            if (user != null) {
                UserEntity userEntity = new UserEntity(user);
                userList.add(userEntity);
            }
        }
        //批量插入
        return this.saveBatch(userList);
    }


    /**
     * excel批量用户导出
     */
    @Override
    public void exportUsersToExcel(HttpServletResponse response) {
        try {
            //从数据库查询到数据
            List<UserEntity> users = this.list();

            //设置信息头，告诉浏览器内容为excel类型
            response.setHeader("content-Type", "application/vnd.ms-excel");
            //设置下载名称
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("学生信息表.xls", StandardCharsets.UTF_8.name()));
            //字节流输出
            ServletOutputStream out = response.getOutputStream();
            //设置excel参数
            ExportParams params = new ExportParams();
            //设置sheet名名称
            params.setSheetName("学生列表");
            //设置标题
            params.setTitle("学生信息表");

            //转成对应的类型;要不然会报错，虽然也可以导出成功
            List<ExportExcelUser> exportUsers = this.changeType(users);
            //导入excel
            Workbook workbook = ExcelExportUtil.exportExcel(params, ExportExcelUser.class, exportUsers);
            //写入
            workbook.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 转成导出vo
     *
     * @param users
     * @return
     */
    private List<ExportExcelUser> changeType(List<UserEntity> users) {
        List<ExportExcelUser> res = new ArrayList<>();
        for (UserEntity user : users) {
            ExportExcelUser exportUser = new ExportExcelUser(user);
            res.add(exportUser);
        }
        return res;
    }

    /**
     * 转成导出vo
     */
    private List<ExportExcelLog> changeInfoType(List<LogInfo> logs) {
        List<ExportExcelLog> res = new ArrayList<>();
        for (LogInfo log : logs) {
            ExportExcelLog exportUser = new ExportExcelLog(log);
            res.add(exportUser);
        }
        return res;
    }


    /**
     * word文档导出
     */
    @Override
    public void exportUsersToWord(HttpServletResponse response) throws Exception {

        //准备导出数据
        List<Map<String, Object>> listUsers = new ArrayList<>();

        //查询所有用户数据
        List<UserEntity> users = this.list();

        users.forEach(user -> {
            Map<String, Object> map = new HashMap<>();

            map.put("name", user.getName());
            map.put("age", user.getAge());
            map.put("sex", user.getSex());
            map.put("address", user.getAddress());
            map.put("describes", user.getDescribes());
            //添加图片
            map.put("image", this.imgFormatting("static/image/刘亦菲.jpg", 100, 100));

            //添加到集合中，一个map就是一行
            listUsers.add(map);
        });
        //导出word并指定word导出模板
        XWPFDocument doc = WordExportUtil.exportWord07("./template/用户导出模板.docx", listUsers);
        //设置编码格式
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        //设置内容类型
        response.setContentType("application/octet-stream");
        //设置头及文件命名。
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("学生基本信息表.docx", StandardCharsets.UTF_8.name()));
        //写入
        doc.write(response.getOutputStream());
    }

    /**
     * word文档导出到一个模板中
     */
    @Override
    public void exportUsersToWordAll(HttpServletResponse response) throws Exception {

        //准备导出数据
        Map<String, Object> mapList = new HashMap<>();
        //准备导出数据
        List<Map<String, Object>> listUsers = new ArrayList<>();

        //查询所有用户数据
        List<UserEntity> users = this.list();
        //添加到循环体中
        //设置一个原子整型。
        AtomicInteger i = new AtomicInteger(1);
        users.forEach(user -> {
            Map<String, Object> map = new HashMap<>();
            //生成序号
            map.put("id", i.getAndIncrement());
            map.put("name", user.getName());
            map.put("age", user.getAge());
            map.put("sex", user.getSex());
            map.put("address", user.getAddress());
            map.put("describes", user.getDescribes());
            //添加图片
            map.put("image", this.imgFormatting(user.getImage(), 100, 100));

            //添加到集合中，一个map就是一行
            listUsers.add(map);
        });
        //添加到返回集合中
        mapList.put("users", listUsers);

        //设置班级
        mapList.put("class", "六(1)班");
        //设置操作人
        mapList.put("operator", "admin");
        //设置当前时间
        mapList.put("createTime", "2022/02/17");

        //导出word并指定word导出模板
        XWPFDocument doc = WordExportUtil.exportWord07("./template/用户导出模板_all.docx", mapList);
        //设置编码格式
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        //设置内容类型
        response.setContentType("application/octet-stream");
        //设置头及文件命名。
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("学生基本信息表.docx", StandardCharsets.UTF_8.name()));
        //写入
        doc.write(response.getOutputStream());
    }

    /**
     * 图片格式化，Word导出图片格式
     *
     * @param imgPath 图片路径
     */
    private ImageEntity imgFormatting(String imgPath, int width, int height) {
        //设置图片
        ImageEntity image = new ImageEntity(imgPath, width, height);
        //表格外添加简单图片
        image.setType(ImageEntity.URL);
        return image;
    }

    /**
     * excel多sheet导入
     */
    @Override
    public void importForSheetUsers(MultipartFile file) throws IOException {

        //分批进行读取sheet工作表
        //读取第一个sheet表
        List<ImportUser> sheetOneUsers = EasyPoiUtils.importExcel(file.getInputStream(), 0, 1, 1, ImportUser.class);
        //读取第二个sheet表
        List<ImportUser> sheetTwoUsers = EasyPoiUtils.importExcel(file.getInputStream(), 1, 1, 1, ImportUser.class);

        //批量插入
        this.saveUsers(sheetOneUsers);
        this.saveUsers(sheetTwoUsers);
    }

    /**
     * excel多sheet导出
     */
    @Override
    public void exportSheetUsers(HttpServletResponse response) {

        //功能描述：把同一个表格多个sheet测试结果重新输出，
        Workbook workBook = null;
        try {
            // 创建参数对象（用来设定excel的sheet1内容等信息）
            ExportParams userExportParams = new ExportParams();
            // 设置sheet得名称
            userExportParams.setSheetName("用户表");
            // 设置sheet表头名称
            userExportParams.setTitle("用户列表");
            // 创建sheet1使用得map
            Map<String, Object> userExportMap = new HashMap<>();
            // title的参数为ExportParams类型，目前仅仅在ExportParams中设置了sheetName
            userExportMap.put("title", userExportParams);
            // 模版导出对应得实体类型
            userExportMap.put("entity", ExportExcelUser.class);
            //转成导出vo类型
            List<ExportExcelUser> users = this.changeType(this.list());
            // sheet1中要填充得数据
            userExportMap.put("data", users);

            // 创建参数对象（用来设定excel的sheet2内容等信息）
            ExportParams logInfoExportParams = new ExportParams();
            logInfoExportParams.setTitle("日志列表");
            logInfoExportParams.setSheetName("日志表");
            // 创建sheet2使用的map
            Map<String, Object> logInfoExportMap = new HashMap<>();
            logInfoExportMap.put("title", logInfoExportParams);
            logInfoExportMap.put("entity", ExportExcelLog.class);
            //查询log数据
            List<LogInfo> logInfoEntitys = logInfoMapper.selectList(new QueryWrapper<>());
            //转成导出vo类型
            List<ExportExcelLog> logInfos = this.changeInfoType(logInfoEntitys);
            // sheet2中要填充得数据
            logInfoExportMap.put("data", logInfos);

            // 将sheet1、sheet2使用得map进行包装
            List<Map<String, Object>> sheetsList = new ArrayList<>();
            //如果后续增加多个List<Map<String, Object>>对象，需要后面继续追加;
            sheetsList.add(userExportMap);
            sheetsList.add(logInfoExportMap);

            // 执行方法
            workBook = ExcelExportUtil.exportExcel(sheetsList, ExcelType.HSSF);
            //设置编码格式
            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
            //设置内容类型
            response.setContentType("application/octet-stream");
            //设置头及文件命名。
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("用户及操作日志导出.xls", StandardCharsets.UTF_8.name()));
            //写出流
            workBook.write(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (workBook != null) {
                try {
                    //强行关流
                    workBook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 导出pdf文件
     */
    @Override
    public void exportPdfUsers(HttpServletResponse response) {

        //准备导出数据
        Map<String, Object> mapList = new HashMap<>();
        //准备导出数据
        List<Map<String, Object>> listUsers = new ArrayList<>();
        try {

            //指定excel模板；我这是在项目根目录下创建了一个template文件夹存放excel导出模板文件
            TemplateExportParams params = new TemplateExportParams("./template/导出excel模板.xlsx");

            //从数据库查询到数据
            List<UserEntity> users = this.list();
            //定义一个原子序列
            AtomicInteger atomicInteger = new AtomicInteger(1);
            users.forEach(user -> {
                Map<String, Object> map = new HashMap<>();
                map.put("id", atomicInteger.getAndIncrement());
                map.put("name", user.getName());
                map.put("age", user.getAge());
                map.put("sex", user.getSex());
                map.put("address", user.getAddress());
                map.put("describes", user.getDescribes());

                //添加到集合中，一个map就是一行
                listUsers.add(map);
            });

            mapList.put("users", listUsers);
            //调用exportExcel()
            Workbook workbook = ExcelExportUtil.exportExcel(params, mapList);

            //定义一个字节输出流
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            //将excel文件写入到新的输出流
            workbook.write(outputStream);
            //将字节数组放置到内存里面
            ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());

            //导入xls包引用Workbook区分poi提供的Workbook
            com.spire.xls.Workbook wb = new com.spire.xls.Workbook();
            wb.loadFromStream(inputStream);
            //设置字段在一页中显示全
            wb.getConverterSetting().setSheetFitToPage(true);

            //指定地址并写出
            wb.saveToFile("D:/pdf/学生基本信息表.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * pdf在线预览
     */
    @Override
    public void previewPdf(HttpServletResponse response) {
        //文件目录
        File file = new File("./template/pdf/学生基本信息表.pdf");
        if (file.exists()) {
            byte[] data = null;
            try {
                FileInputStream input = new FileInputStream(file);
                data = new byte[input.available()];
                input.read(data);
                response.getOutputStream().write(data);
                input.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            return;
        }
    }

    /**
     * 新增用户
     */
    @CachePut(value = "user1",key = "#user.id")
    @Override
    public UserEntity saveUser(UserEntity user) {
        this.save(user);
        log.info("为key(id)为{}的数据做了缓存", user.getId());
        return user;
    }

    /**
     * 查询缓存用户
     */
    @Cacheable(value = "user",key = "#id")
    @Override
    public UserEntity findUserById(Integer id) {
        UserEntity user = this.getById(id);
        log.info("为key(id)为{}的数据做了缓存", user.getId());
        return user;
    }

    /**
     * 根据用户id删除用户
     */
    @CacheEvict(value = "user")
    @Override
    public void deleteUserById(Integer id) {
//        this.removeById(id);
        log.info("删除了key(id)为{}的数据缓存", id);
    }

}
