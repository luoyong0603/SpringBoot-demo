package com.example.demo.annotation;


import com.example.demo.enums.LogTypeEnum;

import java.lang.annotation.*;

/**
 * 自定义注解类  @SysLog
 */
@Target(ElementType.METHOD) //注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME) //注解在哪个阶段执行
@Documented //生成文档
public @interface SysLog {

    // 声明注解成员
    String operation() default "";

    LogTypeEnum logType() default LogTypeEnum.LOG_TYPE_QUERY;   // 日志类型默认是查询类型日志
}
