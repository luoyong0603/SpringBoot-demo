package com.example.demo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * topic初始化
 *
 * @author luoYong
 * @version 1.0
 * @date 2022/2/28 17:39
 */
//@Configuration
public class KafkaConfig {

    /**
     * 创建一个名为topic.test的Topic并设置分区数为8，分区副本数为2
     */
    @Bean
    public NewTopic initialTopic() {
        return new NewTopic("topic.test", 8, (short) 2);
    }
}
