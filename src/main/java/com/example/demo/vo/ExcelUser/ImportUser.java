package com.example.demo.vo.ExcelUser;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;

/**
 * excel导入user参数
 *
 * @author luoYong
 * @version 1.0
 * @date 2022/2/15 14:34
 */
@Data
public class ImportUser implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * @Excel 作用在一个filed上面，对列的描述
     * @param name 列名
     * @param orderNum 下标，从0开始。
     */
    @Excel(name = "姓名", orderNum = "0",width = 10.0)
    private String name;

    @Excel(name = "年龄", orderNum = "1",width = 10.0)
    private Integer age;

    @Excel(name = "性别", orderNum = "2",width = 5.0)
    private String sex;

    @Excel(name = "地址", orderNum = "3",width = 30.0)
    private String address;

    @Excel(name = "用户描述", orderNum = "4",width = 20.0)
    private String describes;

}
