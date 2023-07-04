package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author luoYong
 * @version 1.0
 * @date 2022/11/17 16:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Log4j2Test {

    private static Logger logger = LogManager.getLogger(Log4j2Test.class);

    @Test
    void log4j2Test() throws Exception {
        // 一直打印日志，用于测试Log4j2功能
        logAll();
    }

    // 打印各种级别的日志用于测试
    public static void logAll() throws Exception {

        //TRACE < DEBUG < INFO < WARN < ERROR < FATAL
        logger.trace("trace level log");
        logger.debug("debug level log");
        logger.info("info level log");
        logger.warn("warn level log");
        logger.error("error level log");
        logger.fatal("fatal level log");
    }

}
