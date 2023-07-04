package com.example.demo.enums;

/**
 * 接口返回错误码枚举
 */
public enum ErrorCodeEnum implements IEnum {

    /* 系统异常 */
    SYSTEM_RUNNING(100000, "系统运行异常"),
    SYSTEM_ERROR(101000, "系统未知异常"),
    PARAM_EXIST_EXCEPTION(101001, "参数异常"),

    /* token相关 */
    TOKEN_IS_EMPTY(102001, "该请求没有携带token！请先获取token"),
    TOKEN_IS_INVALID(102002, "token失效，请重新登录！"),
    TOKEN_IS_ERROR(102003, "非法token！请重新登录！"),
    USER_NOT_LOGIN(103006, "请先登录"),


    ;
    private Integer key;
    private String value;

    ErrorCodeEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public Integer getKey() {
        return this.key;
    }

    @Override
    public String getValue() {
        return this.value;
    }

}
