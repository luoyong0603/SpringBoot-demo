package com.example.demo;


import com.alibaba.fastjson.JSON;
import com.example.demo.vo.MessageVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.alibaba.fastjson.serializer.SerializeConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MessageVoTest {

    //根据指定name和age组合进行数据查询
    @Test
    public void fastjsonTest() {
        //实例MessageVo对象
        MessageVo messageVo = new MessageVo(1, "张三", "缴费记录丢失", true);

        // 使用fastjson序列化对象
        String jsonStr = JSON.toJSONString(messageVo);

        // 输出JSON字符串
        System.out.println(jsonStr);
    }





}
