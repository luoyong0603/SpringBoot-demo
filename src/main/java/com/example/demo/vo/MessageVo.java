package com.example.demo.vo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 通知消息结构体
 */
public class MessageVo {

    private Integer id;
    private String name;
    private String content;

    @JSONField( ordinal = 1,name="isSolve") //指定json串中key的名称
    private boolean isSolve;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean getIsSolve() {
        return isSolve;
    }

    public void setIsSolve(boolean isSolve) {
        this.isSolve = isSolve;
    }

    //有参构造
    public MessageVo(Integer id, String name, String content, boolean isSolve) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.isSolve = isSolve;
    }

    //无参构造
    public MessageVo() {
    }
}
