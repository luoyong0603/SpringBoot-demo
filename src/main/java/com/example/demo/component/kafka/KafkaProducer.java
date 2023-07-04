package com.example.demo.component.kafka;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * kafka消息发送端
 *
 * @author luoYong
 * @version 1.0
 * @date 2022/2/28 17:40
 */
@Component
@Slf4j
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void send(Object obj) {
        String obj2String = JSONObject.toJSONString(obj);
        // 发送消息
        kafkaTemplate.send("topic.test", obj).addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                // 发送失败的处理
                log.info("topic[{}] 生产者 发送消息失败[{}]", "topic.test", throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                // 成功的处理
                log.info("topic[{}] 生产者 发送消息成功[{}]", "topic.test", stringObjectSendResult.getProducerRecord().value());
            }
        });
    }

}
