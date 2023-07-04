package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.LogInfoService;
import com.example.demo.vo.ResultResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author luoYong
 * @version 1.0
 * @date 2022/11/21 9:40
 */
@RestController
@RequestMapping("/log")
@Api(tags = "日志相关接口模块", description = "日志相关接口模块")
public class LogInfoController {

    @Autowired
    private LogInfoService logInfoService;


    /**
     * 不分页查询所有日志
     */
    @GetMapping("/get-logs")
    @ApiOperation(value = "不分页查询所有日志", notes = "不分页查询所有日志")
    public ResultResponse<List> getLogList() {
        return new ResultResponse<>(logInfoService.list());
    }

}
