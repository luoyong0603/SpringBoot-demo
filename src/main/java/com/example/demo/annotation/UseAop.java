package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解类  @UseAop
 *
 * @author luoYong
 * @version 1.0
 * @date 2022/1/24 15:26
 */
@Target(ElementType.METHOD) //注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME) //注解在哪个阶段执行
@Documented //生成文档
public @interface UseAop {


}
