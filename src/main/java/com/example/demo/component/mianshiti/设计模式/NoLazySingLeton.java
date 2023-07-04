package com.example.demo.component.mianshiti.设计模式;

/**
 * 手写实现单例模式
 * 饿汉式
 *
 * @author luoYong
 * @version 1.0
 * @date 2022/11/23 11:24
 */
public class NoLazySingLeton {

    // 私有构造方法
    private NoLazySingLeton() {
        System.out.println("生成NoLazySingLeton实例一次！");
    }

    // 在成员位置创建该类的对象
    private static NoLazySingLeton instance = new NoLazySingLeton();

    // 对外提供静态方法获取该对象
    public static NoLazySingLeton getInstance() {
        return instance;
    }


    //测试
    public static void main(String[] args) {
        //调用三遍
        NoLazySingLeton.getInstance();
        NoLazySingLeton.getInstance();
        NoLazySingLeton.getInstance();
    }

}
