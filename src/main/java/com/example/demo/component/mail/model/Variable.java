package com.example.demo.component.mail.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 静态文件对应的key-value
 *
 * @author luoYong
 * @version 1.0
 * @date 2022/1/18 11:25
 */
@ApiModel(value = "静态文件对应的key-value",description = "静态文件对应的key-value")
public class Variable {

    @ApiModelProperty("参数名")
    private String name;

    @ApiModelProperty("值")
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
