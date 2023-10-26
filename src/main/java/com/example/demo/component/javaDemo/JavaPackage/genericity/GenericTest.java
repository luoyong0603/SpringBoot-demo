package com.example.demo.component.javaDemo.JavaPackage.genericity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericTest {
    public static void main(String[] args) {
        // 测试泛型类
        MyClass<String> gc = new MyClass<>();
        gc.setData("Hello World");
        String str = gc.getData();
        System.out.println(str);

        // 测试泛型方法
        List<String> list = Arrays.asList("Java", "Python", "Go");
        String first = GenericMethod.getFirst(list);
        System.out.println(first);

        // 测试泛型的通配符和边界
        GenericBoundary<Integer> gb = new GenericBoundary<>(100);
        Integer data = gb.getData();
        System.out.println(data);

        // 测试泛型在集合框架中的应用
        List<String> strList = new ArrayList<>();
        strList.add("Java");
        strList.add("Python");
        strList.add("Go");
        for (String s : strList) {
            System.out.println(s);
        }
    }
}

