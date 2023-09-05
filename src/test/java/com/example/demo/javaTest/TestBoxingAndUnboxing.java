package com.example.demo.javaTest;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestBoxingAndUnboxing {


    @Test
    public void testBoxingAndUnboxing() {
        // 定义基本类型变量
        int i = 123;
        double d = 3.14;
        boolean b = true;

        // 装箱
        Integer integer = Integer.valueOf(i);
        Double doubleObj = Double.valueOf(d);
        Boolean booleanObj = Boolean.valueOf(b);

        // 拆箱
        int i2 = integer.intValue();
        double d2 = doubleObj.doubleValue();
        boolean b2 = booleanObj.booleanValue();

        // 自动装箱
        Integer integer2 = i;

        // 自动拆箱
        int i3 = integer;

        // 断言装箱和拆箱结果是否正确
        assertEquals(i, i2);
        assertEquals(d, d2, 0);
        assertEquals(b, b2);
        assertEquals(i, integer2.intValue());
        assertEquals(i, i3);
    }
}
