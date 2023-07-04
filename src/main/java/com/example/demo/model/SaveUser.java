package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @author luoYong
 * @version 1.0
 * @date 2022/12/15 14:31
 */
public class SaveUser {

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
}
