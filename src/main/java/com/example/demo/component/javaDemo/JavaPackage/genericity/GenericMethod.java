package com.example.demo.component.javaDemo.JavaPackage.genericity;

import java.util.List;

/**
 * 泛型方法的定义和使用
 */
public class GenericMethod {
    public static <T> T getFirst(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}

