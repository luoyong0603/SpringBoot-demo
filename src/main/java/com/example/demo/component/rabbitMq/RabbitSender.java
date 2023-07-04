package com.example.demo.component.rabbitMq;

import com.example.demo.entity.UserEntity;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 发送者
 *
 * @author luoYong
 * @version 1.0
 * @date 2022/2/24 17:16
 */
@Component
public class RabbitSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * 发送消息
     */
    public void sendMsg() {

        String msg = "简单队列-hello呀";
        System.out.println("Sender : " + msg);
        this.rabbitTemplate.convertAndSend("luoyong-queue", msg);
    }

    /**
     * 发送消息
     */
    public void sendObj() {

        String msg = "简单队列-发送对象啊";
        UserEntity userEntity = new UserEntity();
        userEntity.setName("罗勇");
        System.out.println("Sender object: "+ userEntity.toString());
        this.rabbitTemplate.convertAndSend("luoyong-queue", userEntity);
    }

}
