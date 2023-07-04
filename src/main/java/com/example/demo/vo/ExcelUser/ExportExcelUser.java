package com.example.demo.vo.ExcelUser;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.example.demo.entity.UserEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * excel导出user参数
 *
 * @author luoYong
 * @version 1.0
 * @date 2022/2/15 14:34
 */
@Data
public class ExportExcelUser implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * @Excel 作用在一个filed上面，对列的描述
     * @param name 列名
     * @param orderNum 下标，从0开始。
     */
    @Excel(name = "姓名", width = 10.0)
    private String name;

    @Excel(name = "年龄", width = 10.0)
    private Integer age;

    //字段是Date类型则不需要设置databaseFormat
    @Excel(name = "出生年月", format = "yyyy-MM-dd", width = 20.0)
    private Date bornDate;

    //如果数据库如果是string类型,这个需要设置这个数据库时间格式  format：输出时间格式
    @Excel(name = "入学时间", databaseFormat = "yyyyMMdd", format = "yyyy-MM-dd", width = 20.0)
    private String enterSchoolTime;

    //replace：单元格下拉框，_0表示下拉顺序   suffix：文字后缀 比如：男->男生
    @Excel(name = "性别", width = 10.0, replace = {"男_0", "女_1"}, suffix = "生", addressList = true)
    private String sex;

    @Excel(name = "地址", width = 30.0)
    private String address;

    //@Excel(name = "头像", type = 2, width = 30.0, height = 30.0, savePath = "C:/Users/Administrator/Desktop/code/springboot/template/image/刘亦菲.jpg")
    //imageType 导出类型;1:从file读取;2:是从数据库中读取,默认是文件;同样导入也是一样的
    @Excel(name = "头像", type = 2, width = 30.0, height = 30.0, imageType = 1)
    private String image;

    @Excel(name = "用户描述", width = 20.0)
    private String describes;

    public ExportExcelUser() {

    }

    public ExportExcelUser(UserEntity user) {
        this.name = user.getName();
        this.age = user.getAge();
        this.address = user.getAddress();
        this.sex = user.getSex();
        this.describes = user.getDescribes();
        //设置出生时间
        this.bornDate = new Date();

        //设置入学时间
        this.enterSchoolTime = "20220210";

        //设置图片地址
        this.image = user.getImage();
//        this.image =new String[]{"C:/Users/Administrator/Desktop/code/springboot/template/image/刘亦菲.jpg",
//                "C:/Users/Administrator/Desktop/code/springboot/template/image/杨幂.jpg"};

    }

}
