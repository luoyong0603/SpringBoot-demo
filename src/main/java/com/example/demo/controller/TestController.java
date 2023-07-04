package com.example.demo.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author luoYong
 * @version 1.0
 * @date 2022/11/17 11:25
 */
@Slf4j
@RestController
@RequestMapping("/test")
@Api(tags = "测试模块", description = "测试模块")
public class TestController {

    //开始使用日志进行输出
    @GetMapping("/demo1")
    public void test1() {
        log.info("程序执行咯！记录日志啦");
    }


    //开始使用日志进行输出
    @GetMapping("/demo2")
    public void test2(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
        log.info("程序运算开始咯");
        try {
            if (b == 0) {
                log.error("除数不能为0！");
            } else if (a == 0) {
                log.warn("分子为0！运算无意义");
            } else {
                log.info("a/b=" + a / b);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            log.info("程序运算结束。");
        }
    }

}
