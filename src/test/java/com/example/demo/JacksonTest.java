package com.example.demo;

import com.example.demo.entity.UserEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;

/**
 * @author luoYong
 * @version 1.0
 * @date 2022/11/21 16:05
 */@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class JacksonTest {

    /**
     * json字符串转对象
     */
    @Test
    void testReadValue() throws Exception {
        //1.定义一个json串
        String json = "{id:1,name:bug菌,age:18,sex:男,address:上海市闵行区吴泾镇,describes:12,image:./template/cat.jpg}";
        //2.创建ObjectMapper类
        ObjectMapper mapper = new ObjectMapper();
        UserEntity user = mapper.readValue(json, UserEntity.class);
        //3.打印
        System.out.println(user);
    }

    /**
     * 对象转json字符串
     */
    @Test
    void testWriteValueAsString() throws Exception {
        //1.创建对象
        UserEntity user = new UserEntity();
        user.setId(1);
        user.setName("bug菌");
        user.setSex("男");
        user.setAge(18);
        user.setImage("./template/cat.jpg");
        user.setAddress("上海市闵行区吴泾镇");

        //2.创建ObjectMapper类
        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(user);
        //3.打印
        System.out.println(userJson);

        //4.写入txt文件中
        mapper.writeValue(new File("./template/userJson.txt"), userJson);
    }


}
