package com.example.demo.component.redis.delay;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * 消息处理器（）
 */
//@Component
public class DelayMessageHandler {

    @Autowired
    private DelayQueue delayQueue;

    /**
     * 处理已到期的消息(轮询)
     */
//    @Scheduled(fixedDelay = 1000)
    public void handleExpiredMessages() {
        //获取当前系统时间
        String dateTime = DateFormatUtils.format(new Date(), "hh:MM:ss");

        //扫描任务，并将需要执行的任务加入到任务队列中
        List<DelayMessage> messages = delayQueue.getExpiredMessages();
//        System.out.println(dateTime + " 待处理消息：" + messages);
        //处理消息
        if (!messages.isEmpty()) {
            for (DelayMessage message : messages) {
                System.out.println(dateTime + " 处理消息：" + message.getContent());
                //成功处理消息后，便将消息进行移除。
                delayQueue.remove(message);
            }
        }
    }

}
