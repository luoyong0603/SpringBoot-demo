package com.example.demo.vo;


import com.example.demo.enums.IEnum;
import com.example.demo.enums.ResultEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 接口返回结果，不带对象的
 */
@ApiModel(value = "基础返回信息", description = "基础返回信息")
public class BaseResponse implements Serializable {

    private static final long serialVersionUID = -7671756385477179547L;

    /**
     * api返回码
     */
    @ApiModelProperty("返回编码")
    protected Integer code = ResultEnum.SUCCESS.getKey();
    /**
     * api返回消息
     */
    @ApiModelProperty("返回信息")
    protected String msg = ResultEnum.SUCCESS.getValue();

    /**
     * 服务器时间
     */
    @ApiModelProperty("系统时间")
    protected long serverTime = System.currentTimeMillis();

    public BaseResponse() {

    }

    public BaseResponse(IEnum iEnum) {
        this.code = iEnum.getKey();
        this.msg = iEnum.getValue();
    }

    public BaseResponse(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getServerTime() {
        return serverTime;
    }

    public void setServerTime(long serverTime) {
        this.serverTime = serverTime;
    }

    /**
     * 是否成功
     */
    @ApiModelProperty("是否成功")
    public boolean isSuccess() {
        return ResultEnum.SUCCESS.getKey().equals(code);
    }
}


