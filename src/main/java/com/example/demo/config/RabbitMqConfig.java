package com.example.demo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 声明一个队列
 *
 * @author luoYong
 * @version 1.0
 * @date 2022/2/24 17:10
 */
//@Configuration
public class RabbitMqConfig {


    /**
     * 初始化Queue
     * 创建一个名称为"luoyong-queue"的队列，其他参数使用默认
     * 在创建队列的时候如果要指定其他参数，Queue有多个构造方法可选择
     */
    @Bean
    public Queue helloQueue() {
        return new Queue("luoyong-queue");
    }

}
