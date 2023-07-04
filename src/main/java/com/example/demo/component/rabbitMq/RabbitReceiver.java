package com.example.demo.component.rabbitMq;

import com.example.demo.entity.UserEntity;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消费者
 *
 * @author luoYong
 * @version 1.0
 * @date 2022/2/24 17:19
 */
//@Component
public class RabbitReceiver {

    @RabbitHandler
    public void process1(String msg) {
        System.out.println("Receiver  : 消费成功：" + msg);
    }

    @RabbitListener(queues = "luoyong-queue")  //指定队列
    @RabbitHandler
    public void process(UserEntity msg) {
        System.out.println("Receiver  : 消费成功：消息内容name=" + msg.getName());
    }

}
