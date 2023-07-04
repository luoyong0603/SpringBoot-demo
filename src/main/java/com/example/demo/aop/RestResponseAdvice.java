package com.example.demo.aop;

import com.alibaba.fastjson.JSON;
import com.example.demo.vo.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.validation.constraints.NotNull;

/**
 * 返回结果包装统一返回格式通过切面自动注入。
 */
@Slf4j
@RestControllerAdvice
public class RestResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(@NotNull MethodParameter returnType,
                            @NotNull Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    /**
     * 返回结果包装统一返回格式
     *
     * @return 包装后的返回结果
     */
    @Override
    public Object beforeBodyWrite(Object body,
                                  @NotNull MethodParameter returnType,
                                  @NotNull MediaType selectedContentType,
                                  @NotNull Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  @NotNull ServerHttpRequest request,
                                  ServerHttpResponse response) {
        // 指定返回的结果为application/json格式
        // 不指定，String类型转json后返回Content-Type是text/plain;charset=UTF-8
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        ResultResponse result = new ResultResponse(body);
        // 若返回类型是ResultJson，则不进行修改
        if (body == null) {
            if (returnType.getParameterType().isAssignableFrom(String.class)) {
                return JSON.toJSONString(result);
            }
        } else if (body instanceof ResultResponse) {
            return body;
        } else if (body instanceof String) {
            return JSON.toJSONString(result);
        }
        return result;
    }
}