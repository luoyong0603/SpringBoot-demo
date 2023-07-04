package com.example.demo.exception;

import com.example.demo.enums.ErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author luoYong
 * @version 1.0
 * @date 2023/6/13 11:24
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    private Map<String, Object> getResult(ErrorCodeEnum e, boolean status) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", status);
        map.put("code", e.getKey());
        map.put("msg", e.getValue());
        return map;
    }

    /**
     * 参数校验不通过
     *
     * @param e       异常信息
     * @param request 请求信息
     */
    @ExceptionHandler(value = ParamsException.class)
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> handleObjectExistException(ParamsException e,
                                                          HttpServletRequest request) {
        return getResult(ErrorCodeEnum.PARAM_EXIST_EXCEPTION, false);
    }

    /**
     * 用户校验不通过
     *
     * @param e       异常信息
     * @param request 请求信息
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = TokenExpireException.class)
    public Map<String, Object> handle(TokenExpireException e, HttpServletRequest request) {
        return getResult(ErrorCodeEnum.USER_NOT_LOGIN, false);
    }

    /**
     * 全局异常处理
     *
     * @param e       异常信息
     * @param request 请求信息
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = SystemRunningException.class)
    public Map<String, Object> handle(SystemRunningException e, HttpServletRequest request) {
        return getResult(ErrorCodeEnum.SYSTEM_RUNNING, false);
    }

    /**
     * 全局异常处理
     *
     * @param e       异常信息
     * @param request 请求信息
     */
    @ResponseStatus()
    @ExceptionHandler(value = Throwable.class)
    public Map<String, Object> handle(Exception e, HttpServletRequest request) {
        return getResult(ErrorCodeEnum.SYSTEM_ERROR, false);
    }


}
