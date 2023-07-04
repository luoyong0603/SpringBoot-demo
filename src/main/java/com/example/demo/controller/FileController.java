package com.example.demo.controller;

import com.example.demo.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * 文件类相关接口
 *
 * @author luoYong
 * @version 1.0
 * @date 2022/9/23 10:26
 */
@RestController
@RequestMapping("/file")
@Api(tags = "文件类相关接口模块", description = "文件类相关接口模块")
public class FileController {

    @Autowired
    private FileService fileService;

    /**
     * 数据导出成.csv文件
     */
    @GetMapping("/export-csv")
    @ApiOperation(value = "数据导出成.csv文件", notes = "数据导出成.csv文件")
    public void exportCsvFile() throws IOException {
        fileService.exportCsvFile();
    }


}
