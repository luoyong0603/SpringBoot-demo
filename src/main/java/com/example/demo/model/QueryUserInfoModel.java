package com.example.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;


@ApiModel(value = "查询用户参数体",description = "查询用户参数体")
public class QueryUserInfoModel {

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty("班级名称")
    private String className;

    @ApiModelProperty("用户ids")
    private List<Integer> userIds;


    public List<Integer> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
