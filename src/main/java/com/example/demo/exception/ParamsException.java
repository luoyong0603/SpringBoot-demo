package com.example.demo.exception;

import com.example.demo.enums.ErrorCodeEnum;

/**
 * 参数异常
 *
 * @Author luoYong
 * @Date 2022-03-30 13:00
 */
public class ParamsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String message;

    public ParamsException() {
    }

    public ParamsException(String msg) {
        this.message = msg;
    }

    public ParamsException(ErrorCodeEnum e) {
        this.message = e.getValue();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
