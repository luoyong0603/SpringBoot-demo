package com.example.demo.component.kafka;

import com.example.demo.component.rabbitMq.RabbitSender;
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
public class KafkaTest {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Test
    public void testSendMsg() {
        String msg = "hello";
        kafkaProducer.send(msg);
    }


}
