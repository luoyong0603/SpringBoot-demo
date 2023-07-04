package com.example.demo.component.rabbitMq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author luoYong
 * @version 1.0
 * @date 2022/2/24 17:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RabbitMqConfigTest {


    @Autowired
    private RabbitSender rabbitSender;


//    // 发送单条消息
//    @Test
//    public void testStringMsg() {
//        rabbitSender.sendMsg();
//    }

    // 发送单条消息-user对象
    @Test
    public void testSendUserMsg() {
        rabbitSender.sendObj();
    }

}
