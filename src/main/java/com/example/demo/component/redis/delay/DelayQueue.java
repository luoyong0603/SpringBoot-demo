package com.example.demo.component.redis.delay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * 延时队列类
 */
@Component
public class DelayQueue {

    private static final String KEY = "delay_queue";

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 添加消息到延时队列中
     */
    public void put(DelayMessage message) {
        redisTemplate.opsForZSet().add(KEY, message, message.getExpireTime());
    }

    /**
     * 从延时队列中删除消息
     */
    public void remove(DelayMessage message) {
        redisTemplate.opsForZSet().remove(KEY, message);
    }

    /**
     * 获取延时队列中已到期的消息
     */
    public List<DelayMessage> getExpiredMessages() {
        long minScore = 0;
        long maxScore = System.currentTimeMillis();
        Set<Object> messages = redisTemplate.opsForZSet().rangeByScore(KEY, minScore, maxScore);
        if (messages == null || messages.isEmpty()) {
            return Collections.emptyList();
        }
        List<DelayMessage> result = new ArrayList<>();
        for (Object message : messages) {
            result.add((DelayMessage) message);
        }
        return result;
    }

}
