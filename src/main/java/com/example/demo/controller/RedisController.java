package com.example.demo.controller;

import com.example.demo.component.redis.mediat.RedisMediator;
import com.example.demo.component.redis.message.Publisher;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * redis相关控制器
 */
@RestController
@RequestMapping("/redis")
@Api(tags = "redis相关控制器", description = "redis相关控制器")
public class RedisController {

//    @Autowired
//    private Publisher publisher;

//    /**
//     * 模拟发布消息
//     */
//    @GetMapping("/publish")
//    public String publish(@ApiParam("通道名") @RequestParam String channel,
//                          @ApiParam("消息体") @RequestParam String message) {
//        // 发送消息
//        return publisher.sendMessage(channel, message);
//    }


}
