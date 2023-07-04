package com.example.demo.exception;

import com.example.demo.enums.ErrorCodeEnum;

/**
 * 用户登陆信息过期异常
 */
public class TokenExpireException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String message;

    public TokenExpireException() {
    }

    public TokenExpireException(String msg) {
        this.message = msg;
    }

    public TokenExpireException(ErrorCodeEnum e) {
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
