package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.exception.ParamsException;
import com.example.demo.exception.TokenExpireException;
import com.example.demo.service.UserService;
import com.example.demo.vo.ResultResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.example.demo.enums.ErrorCodeEnum.PARAM_EXIST_EXCEPTION;

/**
 * @author luoYong
 * @version 1.0
 * @date 2023/6/13 14:06
 */
@RestController
@RequestMapping("/exception")
@Api(tags = "全局异常测试模块", description = "全局异常测试模块")
public class ExceptionController {

    @Autowired
    private  UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    /**
     * 根据用户id查询用户信息
     */
    @GetMapping("/find-user-by-id")
    @ApiOperation(value = "根据用户id查询用户信息", notes = "根据用户id查询用户信息")
    public ResultResponse<UserEntity> saveUser(@RequestParam("userId") String userId) throws ParamsException {
        if (StringUtils.isBlank(userId)) {
            throw new ParamsException(PARAM_EXIST_EXCEPTION);
        }
        return new ResultResponse<>(userService.getById(userId));
    }

    @GetMapping("/login")
    @ApiOperation(value = "登录", notes = "登录")
    public ResultResponse<Boolean> login(@RequestParam("token") String token) throws TokenExpireException {
        throw new TokenExpireException();
    }

}
