package com.example.demo.aop;

import com.example.demo.annotation.SysLog;
import com.example.demo.entity.LogInfo;
import com.example.demo.enums.ResultEnum;
import com.example.demo.service.LogInfoService;
import com.example.demo.util.IpUtils;
import com.example.demo.util.SpringServletContextUtils;
import com.example.demo.vo.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Date;

/**
 * 系统日志：切面处理类
 *
 * @author luoYong
 * @version 1.0
 * @date 2022/1/24 12:48
 */
@Slf4j
@Aspect
@Component
public class SysLogAspect {

    @Autowired
    private LogInfoService iLogInfoService;

    /**
     * 环绕通知 用于拦截指定内容，记录用户的操作
     * pjp:ProceedingJoinPoint 是切入点对象
     * com.example.demo.controller.*.*(..)) 解析
     * 1、第一个*表示是返回任意类型
     * 2、com.nl.demo.controllers是包路径，针对所有的控制器
     * 3、第二个*是任意类
     * 4、第三个*是任意方法
     * 5、(..)的任意参数
     *
     * @param pjp 切入点
     */
//    @Around("execution(public * com.example.demo.controller.*.*(..))")
    public Object postLogAspect(ProceedingJoinPoint pjp) throws Throwable {
        //初始化log
        LogInfo log = this.createOpLog();
        Object result = this.proceedController(pjp, log);
        //获取操作类型
        this.getLogType(pjp, log);
        //获取返回值编码code
        BaseResponse resData = this.setResponseCode(log, result);
        //赋值返回编码
        log.setResponseCode(resData.getCode());
        //记录非成功异常
        if (log.getResponseCode() != ResultEnum.SUCCESS.getKey()) {
            //记录异常
            log.setException(resData.getMsg());
        }
        //调用service保存SysLog实体类到数据库
        iLogInfoService.save(log);
        return result;
    }

    /**
     * 获取操作类型
     */
    private void getLogType(ProceedingJoinPoint pjp, LogInfo log) {

        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();
        //获取操作
        SysLog sysLog = method.getAnnotation(SysLog.class);
        if(sysLog == null){
            log.setLogType(null);
            return;
        }
        //获取
        log.setLogType(sysLog.logType().getValue());
    }


    /**
     * 得到request对象
     */
    private HttpServletRequest getRequest() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        return request;
    }


    /**
     * 构建日志对象
     */
    private LogInfo createOpLog() {
        HttpServletRequest request = this.getRequest();
        LogInfo log = new LogInfo();
        log.setQuery(request.getQueryString());
        this.setBody(request, log);
        log.setOperateTime(new Date());
        log.setUrl(request.getServletPath());
        log.setIp(getIpAddress());
        return log;
    }

    /**
     * 记录接口消耗时间
     *
     * @param log 日志对象
     */
    private Object proceedController(ProceedingJoinPoint pjp, LogInfo log) throws Throwable {
        //记录开始接口时间
        long spendTime = System.currentTimeMillis();
        //调用目标接口及获取返回结果
        Object result = pjp.proceed(pjp.getArgs());
        //调用目标接口结束
        //计算接口耗时
        spendTime = (System.currentTimeMillis() - spendTime) / 1000;
        log.setSpendTime(spendTime);
        return result;
    }

    /**
     * 设置接口返回值
     *
     * @param log    日志对象
     * @param result 接口返回值
     */
    private BaseResponse setResponseCode(LogInfo log, Object result) {
        //判断返回体类型是否为BaseResponse
        if (result != null && result instanceof BaseResponse) {
            BaseResponse restResult = (BaseResponse) result;
            return restResult;
        }
        return new BaseResponse();
    }


    /**
     * 设置请求体
     *
     * @param request 请求信息
     * @param log     日志对象
     */
    private void setBody(HttpServletRequest request, LogInfo log) {
        if (request instanceof ContentCachingRequestWrapper) {
            ContentCachingRequestWrapper wrapper = (ContentCachingRequestWrapper) request;
            String body = StringUtils.toEncodedString(wrapper.getContentAsByteArray(),
                    Charset.forName(wrapper.getCharacterEncoding()));
            log.setBody(body);
        }
    }

    /**
     * 获取ip地址
     */
    private String getIpAddress() {
        // 通过RequestContextHolder获取request对象
        HttpServletRequest request = SpringServletContextUtils.getRequest();
        if (request != null) {
            try {
                return IpUtils.getIpAddr(request);
            } catch (Exception e) {
                log.error("unable to get ip address");
            }
        }
        return null;
    }


}
