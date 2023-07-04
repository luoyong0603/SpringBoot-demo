//package com.example.demo.config;
//
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisOperations;
//import org.springframework.data.redis.core.StringRedisTemplate;
//
///**
// * redis配置类
// *
// * @Author luoYong   
// * @Date 2022-01-20 17:29       
// */
//@Configuration
//@ConditionalOnClass(RedisOperations.class)
//@EnableConfigurationProperties(RedisProperties.class)
//public class RedisConfig {
//
//	/**
//	 * 字符串Template
//	 *
//	 * @param connection redis连接
//	 */
//	@Bean
//	@ConditionalOnMissingBean(StringRedisTemplate.class)
//	public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory connection) {
//		StringRedisTemplate template = new StringRedisTemplate();
//		template.setConnectionFactory(connection);
//		return template;
//	}
//
//}
