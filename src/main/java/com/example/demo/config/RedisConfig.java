package com.example.demo.config;

import com.example.demo.component.redis.message.Receiver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * redis配置类
 */
//@Configuration
/*
@ConditionalOnClass(RedisOperations.class)
@EnableConfigurationProperties(RedisProperties.class)
public class RedisConfig {

    */
/**
     * 字符串Template
     *
     * @param connection redis连接
     *//*

    @Bean
    @ConditionalOnMissingBean(StringRedisTemplate.class)
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory connection) {
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(connection);
        return template;
    }

    */
/**
     * 配置监听器
     *//*

    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory factory,
                                                   Receiver listener) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(factory);
        //订阅频道 bug_music 和 bug_news
        //这个container可以添加多个redis频道(监听多个)
        container.addMessageListener(listener, new ChannelTopic("bug_music"));
        container.addMessageListener(listener, new ChannelTopic("bug_news"));

            //通过通配符的形式配置多个监听通道，与上述方式同为实现方式，取其一即可，也可二者兼用。
//        container.addMessageListener(listener,  patternTopic());

        return container;
    }

    */
/**
     * 订阅匹配的多个频道
     *//*

    @Bean
    public PatternTopic patternTopic() {
        return new PatternTopic("bug_*");
    }


}*/
