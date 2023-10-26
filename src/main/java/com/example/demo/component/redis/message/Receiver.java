package com.example.demo.component.redis.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * redis:接收消息者
 */
//@Component
public class Receiver implements MessageListener {
    private static Logger logger = LoggerFactory.getLogger(Receiver.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void onMessage(Message message, byte[] bytes) {

        // 获取消息体
        byte[] messageBody = message.getBody();
        // 使用值序列化器转换
        Object msg = redisTemplate.getValueSerializer().deserialize(messageBody);
        // 获取监听的频道
        byte[] channelByte = message.getChannel();
        // 使用字符串序列化器转换
        Object channel = redisTemplate.getStringSerializer().deserialize(channelByte);

        // 收到消息的处理逻辑，演示的话这里就只做打印处理
        logger.info("---频道---: " + channel);
        // 收到消息的处理逻辑，演示的话这里就只做打印处理
        logger.info("---消息内容---: " + msg);
    }
}
