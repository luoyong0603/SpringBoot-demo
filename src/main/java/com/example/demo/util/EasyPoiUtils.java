package com.example.demo.util;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author luoYong
 * @version 1.0
 * @date 2022/2/21 10:40
 */
public class EasyPoiUtils {


    /**
     * 功能描述：根据接收的Excel文件来导入多个sheet,根据索引可返回一个集合
     *
     * @param inputStream excel输入流
     * @param sheetIndex  导入sheet索引
     * @param titleRows   表标题的行数
     * @param headerRows  表头行数
     * @param pojoClass   Excel实体类
     * @return
     */
    public static <T> List<T> importExcel(InputStream inputStream, int sheetIndex, Integer titleRows, Integer headerRows, Class<T> pojoClass) {
        // 根据file得到Workbook,主要是要根据这个对象获取,传过来的excel有几个sheet页
        ImportParams params = new ImportParams();
        // 第几个sheet页
        params.setStartSheetIndex(sheetIndex);
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(inputStream, pojoClass, params);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("模板不能为空");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * 获取Excel sheet页的数量
     */
    public static int getSheetCount(String path) throws IOException {
        FileInputStream fileInput = new FileInputStream(path);
        POIFSFileSystem fs = new POIFSFileSystem(fileInput);
        HSSFWorkbook hs = new HSSFWorkbook(fs);
        return hs.getNumberOfSheets();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(EasyPoiUtils.getSheetCount("C:/Users/Administrator/Desktop/专业能力等级（职称）评审平台/菜单列表.xls"));
    }


}
