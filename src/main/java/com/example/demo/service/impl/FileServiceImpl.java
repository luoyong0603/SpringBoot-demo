package com.example.demo.service.impl;

import com.example.demo.service.FileService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author luoYong
 * @version 1.0
 * @date 2022/9/23 10:29
 */
@Service
public class FileServiceImpl implements FileService {

    /**
     * 数据导出成.csv文件
     */
    @Override
    public void exportCsvFile() throws IOException {

        //我们如下就具体模拟数据进行导出懂啊csv文件了啊

        //csv文件存放地址
        String path = "./template/test.csv";
        //拼接好转接的内容(这里我们就模拟一下啊)
        String word = "";
        //先把第一列表头固定好
        String tableNames = "id,name,age,address";
        //接着就是对于的数据内容。
        String oneRow = "1,胡歌,30,北京朝阳";
        String twoRow = "2,吴彦祖,2,深圳龙岗";
        String threeRow = "3,范冰冰,30,上海徐汇";
        String fourRow = "4,周杰伦,22,中国台湾";

        //进行换行
        word += tableNames + "\r\n";
        word += oneRow+ "\r\n";
        word += twoRow+ "\r\n";
        word += threeRow+ "\r\n";
        word += fourRow+ "\r\n";

        //调用方法转csv文件
        this.buildCsvFile(path,word);
    }

    /**
     * 将字符串转成csv文件
     */
    public void buildCsvFile(String savePath,String contextStr) throws IOException {

        //创建存放
        File file = new File(savePath);
        //创建文件
        file.createNewFile();
        //创建文件输出流
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        //将指定字节写入此文件输出流
        fileOutputStream.write(contextStr.getBytes("gbk"));
        fileOutputStream.flush();
        fileOutputStream.close();
    }

}
