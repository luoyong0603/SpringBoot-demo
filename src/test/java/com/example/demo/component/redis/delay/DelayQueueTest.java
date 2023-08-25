package com.example.demo.component.redis.delay;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author luoYong
 * @version 1.0
 * @date 2023/8/23 18:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DelayQueueTest {
    @Autowired
    private DelayQueue delayQueue;

    @Test
    public void testDelayQueue() {
        //获取当前系统时间
        long newDate = System.currentTimeMillis();

        // 添加消息：1秒后到期
        DelayMessage message1 = new DelayMessage("1", "delay message 1", newDate + 1000);
        // 添加消息：3秒后到期
        DelayMessage message2 = new DelayMessage("2", "delay message 2", newDate + 3000);
        // 添加消息：6秒后到期
        DelayMessage message3 = new DelayMessage("3", "delay message 3", newDate + 6000);
        // 添加消息：10秒后到期
        DelayMessage message4 = new DelayMessage("4", "delay message 4", newDate + 10000);

        delayQueue.put(message1);//1s后执行
        delayQueue.put(message2);//3s后执行
        delayQueue.put(message3);//6s后执行
        delayQueue.put(message4);//10s后执行
    }

}

