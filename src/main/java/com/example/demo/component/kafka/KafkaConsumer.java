package com.example.demo.component.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 消息接收端-支持多端消费
 *
 * @author luoYong
 * @version 1.0
 * @date 2022/2/28 17:42
 */
//@Component
@Slf4j
public class KafkaConsumer {
    @KafkaListener(topics = "topic.test", groupId = "topic.group1")
    public void topicTest(ConsumerRecord<?, ?> record, Acknowledgment ack, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {

        Optional message = Optional.ofNullable(record.value());
        if (message.isPresent()) {
            Object msg = message.get();
            log.info("客户端 A 消费了： Topic[{}] Message[{}]", topic, msg);
            ack.acknowledge();
        }
    }

    @KafkaListener(topics = "topic.test", groupId = "topic.group1")
    public void topicTest1(ConsumerRecord<?, ?> record, Acknowledgment ack, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {

        Optional message = Optional.ofNullable(record.value());
        if (message.isPresent()) {
            Object msg = message.get();
            log.info("客户端 B 消费了： Topic[{}] Message[{}]", topic, msg);
            ack.acknowledge();
        }
    }


}
