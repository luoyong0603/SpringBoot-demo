package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import com.example.demo.vo.ResultResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author luoYong
 * @version 1.0
 * @date 2022/12/15 11:04
 */
@RestController
@RequestMapping("/cache")
@Api(tags = "测试用户缓存模块", description = "测试用户缓存模块")
public class CacheController {

    @Autowired
    private UserService userService;

    /**
     * 新增用户
     */
    @PostMapping("/save-user")
    @ApiOperation(value = "新增用户", notes = "新增用户")
    public ResultResponse<UserEntity> saveUser(@RequestBody UserEntity user) {
        return new ResultResponse<>(userService.saveUser(user));
    }

    /**
     * 根据用户id查询用户信息
     */
    @GetMapping("/get-user-by-id")
    @ApiOperation(value = "根据用户id查询用户信息", notes = "根据用户id查询用户信息")
    public ResultResponse<UserEntity> findUserById(@RequestParam("id") Integer id) {
        return new ResultResponse<>(userService.findUserById(id));
    }

    /**
     * 根据用户id删除缓存用户信息
     */
    @GetMapping("/delete-user-by-id")
    @ApiOperation(value = "根据用户id删除缓存用户信息", notes = "根据用户id删除缓存用户信息")
    public void deleteUserById(@RequestParam("id") Integer id) {
        userService.deleteUserById(id);
    }

}
