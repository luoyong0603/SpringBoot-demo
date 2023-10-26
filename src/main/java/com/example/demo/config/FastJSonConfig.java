package com.example.demo.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.Charset;

/**
 * @author luoYong
 * @version 1.0
 * @date 2023/8/31 11:31
 */
//@Configuration
public class FastJSonConfig {

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        // 创建FastJson消息转换器
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();

        // 创建配置对象
        FastJsonConfig config = new FastJsonConfig();

        // 配置序列化策略
        config.setSerializerFeatures(
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteDateUseDateFormat
        );

        // 配置字符集
        converter.setDefaultCharset(Charset.forName("UTF-8"));

        // 将配置添加到转换器中
        converter.setFastJsonConfig(config);

        // 返回HttpMessageConverters对象
        return new HttpMessageConverters(converter);
    }


}
