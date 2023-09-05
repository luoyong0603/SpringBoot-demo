package com.example.demo.component.javaDemo.JavaPackage.reflect;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo {

    public static void main(String[] args) throws Exception {
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

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }


}
