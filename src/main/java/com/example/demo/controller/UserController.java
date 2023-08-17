package com.example.demo.controller;

import com.example.demo.annotation.SysLog;
import com.example.demo.entity.UserEntity;
import com.example.demo.enums.ErrorCodeEnum;
import com.example.demo.enums.LogTypeEnum;
import com.example.demo.vo.ResultResponse;
import com.example.demo.vo.UserInfoVo;
import com.example.demo.dao.UserMapper;
import com.example.demo.model.QueryUserInfoModel;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


/**
 * 用户管理分发器
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理模块", description = "用户管理模块")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    /**
     * 不分页查询db1所有用户信息
     */
    @GetMapping("/get-users1")
    @ApiOperation(value = "不分页查询db1所有用户信息", notes = "不分页查询db1所有用户信息")
    public ResultResponse<List<UserEntity>> getUserList1() {
        return new ResultResponse<>(ErrorCodeEnum.SYSTEM_ERROR);
    }

    /**
     * 不分页查询db2所有用户信息
     */
    @GetMapping("/get-users2")
    @ApiOperation(value = "不分页查询db2所有用户信息", notes = "不分页查询db2所有用户信息")
    public List<UserEntity> getUserList2() {
        return userService.getUsers2();
    }

    /**
     * 根据性别查询所有用户
     *
     * @param sex 性别
     */
    @GetMapping("/get-users-by-sex")
    @ApiOperation(value = "根据性别查询所有用户", notes = "根据性别查询所有用户")
    public ResultResponse<List<UserEntity>> getUsersBySex(@RequestParam(name = "sex") String sex) {
        return new ResultResponse<>(userService.getUsersBySex(sex));
    }

    /**
     * 根据用户id查询用户信息
     *
     * @param userId
     * @return
     */
    @SysLog(logType = LogTypeEnum.LOG_TYPE_QUERY)
    @GetMapping("/getUser-by-id")
    @ApiOperation(value = "根据用户id查询用户信息", notes = "根据用户id查询用户信息")
    public ResultResponse<UserEntity> getUserById(@RequestParam(name = "userId") @ApiParam("请输入用户id") String userId) {
        return new ResultResponse<>(userService.getById(userId));
    }
    

    /**
     * 根据用户ids等参数联合查询用户信息
     */
    @PostMapping("/getUser-by-ids")
    @ApiOperation(value = "根据用户ids等参数联合查询用户信息", notes = "根据用户ids等参数联合查询用户信息")
    public List<UserInfoVo> getUserById(@RequestBody QueryUserInfoModel model) {
        return userMapper.getUsersByIds(model.getUserIds());
    }

    /**
     * 根据用户条件查询符合条件的用户信息
     *
     * @param model
     * @return
     */
    @PostMapping("/get-user-infos")
    @ApiOperation(value = "根据用户条件查询符合条件的用户信息", notes = "根据用户条件查询符合条件的用户信息")
    public List<UserInfoVo> getUserInfo(@RequestBody QueryUserInfoModel model) {
        return userMapper.getUsers(model);
    }


    /**
     * 根据id查询区分性别返回不同结构体内容
     */
    @GetMapping("/get-user-for-id")
    @ApiOperation(value = "根据id查询区分性别返回不同结构体内容", notes = "根据id查询区分性别返回不同结构体内容")
    public List<UserEntity> getUserInfo(@RequestParam Integer id) {
        return userMapper.getUserByIdFor(id);
    }


    /**
     * 不分页查询所有用户信息
     *
     * @return
     */
    @GetMapping("/get-user-list")
    @ApiOperation(value = "不分页查询所有用户信息", notes = "不分页查询所有用户信息")
    public List<UserEntity> getUsersList() {
        return userMapper.getUserList();
    }

    /**
     * 根据id修改用户信息
     */
    @PostMapping("/update-user-by-id")
    @ApiOperation(value = "根据id修改用户信息", notes = "根据id修改用户信息")
    public boolean updateUserById(@RequestBody UserEntity userEntity) {
        return userService.updateByUserId(userEntity);
    }


    /**
     * excel批量导入用户
     */
    @GetMapping("/import")
    @ApiOperation(value = "excel批量导入用户", notes = "excel批量导入用户")
    public ResultResponse<Boolean> importUsers(@RequestParam("file") MultipartFile file) {
        return new ResultResponse<>(userService.importUsers(file));
    }

    /**
     * excel批量用户导出
     */
    @GetMapping("/export")
    @ApiOperation(value = "excel批量用户导出", notes = "excel批量用户导出")
    public void exportUsersToExcel(HttpServletResponse response) {
        userService.exportUsersToExcel(response);
    }

    /**
     * word文档导出
     */
    @GetMapping("/export-word")
    @ApiOperation(value = "word文档导出", notes = "word文档导出")
    public void exportUsersToWord(HttpServletResponse response) throws Exception {
        userService.exportUsersToWord(response);
    }

    /**
     * word文档导出到一个模板中
     */
    @GetMapping("/export-word-all")
    @ApiOperation(value = "word文档导出到一个模板中", notes = "word文档导出到一个模板中")
    public void exportUsersToWordAll(HttpServletResponse response) throws Exception {
        userService.exportUsersToWordAll(response);
    }

    /**
     * excel多sheet导入
     */
    @GetMapping("/import-for-sheets")
    @ApiOperation(value = "excel多sheet导入", notes = "excel多sheet导入")
    public void importForSheetUsers(@RequestParam("file") MultipartFile file) throws IOException {
        userService.importForSheetUsers(file);
    }

    /**
     * excel多sheet导出
     */
    @GetMapping("/export-for-sheets")
    @ApiOperation(value = "excel多sheet导出", notes = "excel多sheet导出")
    public void exportSheetUsers(HttpServletResponse response) {
        userService.exportSheetUsers(response);
    }

    /**
     * 导出pdf文件
     */
    @GetMapping("/export-for-pdf")
    @ApiOperation(value = "导出pdf文件", notes = "导出pdf文件")
    public void exportPdfUsers(HttpServletResponse response) {
        userService.exportPdfUsers(response);
    }

    /**
     * pdf在线预览
     */
    @RequestMapping("/preview")
    public void previewPdf(HttpServletResponse response) {
        userService.previewPdf(response);
    }


}
