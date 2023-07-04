package com.example.demo.service;

import java.io.IOException;

/**
 * @author luoYong
 * @version 1.0
 * @date 2022/9/23 10:29
 */
public interface FileService {

    /**
     * 数据导出成.csv文件
     */
    void exportCsvFile() throws IOException;
}
