package com.example.demo.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.UserEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * 用户管理业务层接口
 */
public interface UserService extends IService<UserEntity> {

    /**
     * 不分页查询所有用户信息
     */
    List<UserEntity> getUsers1();

    List<UserEntity> getUsers2();

    /**
     * 根据性别查询所有用户
     *
     * @param sex 性别
     */
    List<UserEntity> getUsersBySex(String sex);

    UserEntity getUserById(String id);

    boolean updateByUserId(UserEntity userEntity);

    /**
     * excel批量导入用户
     *
     * @param file excel文件
     */
    Boolean importUsers(MultipartFile file);

    /**
     * excel批量用户导出
     */
    void exportUsersToExcel(HttpServletResponse response);


    /**
     * word文档导出
     */
    void exportUsersToWord(HttpServletResponse response) throws Exception;

    /**
     * word文档导出到一个模板中
     */
    void exportUsersToWordAll(HttpServletResponse response) throws Exception;

    /**
     * excel多sheet导入
     */
    void importForSheetUsers(MultipartFile file) throws IOException;

    /**
     * excel多sheet导出
     */
    void exportSheetUsers(HttpServletResponse response);

    /**
     * 导出pdf文件
     */
    void exportPdfUsers(HttpServletResponse response);

    /**
     * pdf在线预览
     */
    void previewPdf(HttpServletResponse response);

    /**
     * 新增用户
     */
    UserEntity saveUser(UserEntity user);

    /**
     * 查询缓存用户
     */
    UserEntity findUserById(Integer id);

    /**
     * 根据用户id删除用户
     */
    void deleteUserById(Integer id);
}
