package com.example.demo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.demo.vo.ExcelUser.ImportUser;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户基本信息实体
 */
@TableName("user")
@Data
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO) //表示该id为自增，新增时候不需要手动设置id。
    private Integer id;

    @TableField(value = "name")
    private String name;

    @TableField(value = "age")
    private Integer age;

    @TableField(value = "sex")
    private String sex;

    @TableField(value = "address")
    private String address;

    @TableField(value = "describes")
    private String describes;

    @TableField(value = "image")
    private String image;


    @Override
    public String toString() {
        return this.id + " - " + this.name + " - " + this.getSex();
    }

    public UserEntity() {

    }

    public UserEntity(ImportUser user) {
        this.name = user.getName();
        this.age = user.getAge();
        this.sex = user.getSex();
        this.address = user.getAddress();
        this.describes = user.getDescribes();
    }

}
