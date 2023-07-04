package com.example.demo.component.mianshiti.设计模式;

import lombok.Synchronized;

/**
 * 手写实现单例模式
 * 懒汉式(双重检查锁)
 *
 * @author luoYong
 * @version 1.0
 * @date 2022/11/23 14:15
 */
public class DoubleLazySingLeton {


    // 私有构造方法
    private DoubleLazySingLeton() {
        System.out.println("生成DoubleLazySingLeton实例一次！");
    }

    private static volatile DoubleLazySingLeton instance;

    // 对外提供静态方法获取该对象
    public static DoubleLazySingLeton getInstance() {
        // 第一次判断，如果instance不为null，不进入抢锁阶段，直接返回实例
        if (instance == null) {
            //instance未实例化的时候才加锁
            synchronized (DoubleLazySingLeton.class) {
                if (instance == null) {
                    instance = new DoubleLazySingLeton();
                }
            }
        }
        return instance;
    }
}
