package com.example.demo.component.redis.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * redis:消息生产者
 */
//@Service
public class Publisher {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public String sendMessage(String channel, String message) {
        try {
            //消息发送
            redisTemplate.convertAndSend(channel, message);
            return "消息发送成功了!";
        } catch (Exception e) {
            e.printStackTrace();
            return "消息发送失败了!";
        }
    }
}
