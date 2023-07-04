package com.example.demo.exception;


import com.example.demo.enums.ErrorCodeEnum;

/**
 * 系统异常
 *
 * @Author luoYong
 * @Date 2022-03-30 13:00
 */
public class SystemRunningException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String message;

    public SystemRunningException(ErrorCodeEnum e) {
        this.message = e.getValue();
    }

    public SystemRunningException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
