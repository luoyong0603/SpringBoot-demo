package com.example.demo.javaTest.reflect;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReflectDemoTest {


    @Test
    public void testReflect() throws Exception {
        // 获取类的Class对象
        Class<?> clazz = Class.forName("com.example.demo.component.javaDemo.JavaPackage.reflect.User");

        // 创建对象
        Object obj = clazz.newInstance();

        // 调用方法
        Method setNameMethod = clazz.getMethod("setName", String.class);
        setNameMethod.invoke(obj, "Tom");
        Method setAgeMethod = clazz.getMethod("setAge", int.class);
        setAgeMethod.invoke(obj, 18);

        // 访问属性
        Field nameField = clazz.getDeclaredField("name");
        nameField.setAccessible(true);
        String name = (String) nameField.get(obj);
        Field ageField = clazz.getDeclaredField("age");
        ageField.setAccessible(true);
        int age = ageField.getInt(obj);

        // 断言
        assertEquals("Tom", name);
        assertEquals(18, age);
    }
}
