package com.example.demo.component.mianshiti.设计模式;

/**
 * 手写实现单例模式
 * 懒汉式(线程安全)
 *
 * @author luoYong
 * @version 1.0
 * @date 2022/11/23 11:24
 */
public class LazySingLeton {

    //私有构造方法
    private LazySingLeton() {
        System.out.println("生成LazySingLeton实例一次");
    }

    //在成员位置创建该类的对象
    private static LazySingLeton instance = null;

    /**
     * 整个方法用了synchronized关键字进行方法同步，这个缺点很是明显，
     * 就是锁的粒度太大，很多线程同时访问的时候导致阻塞很严重。
     */
    public synchronized static LazySingLeton getInstance() {
        if (instance == null) {
            instance = new LazySingLeton();
        }
        return instance;
    }

    //测试
    public static void main(String[] args) {
        LazySingLeton.getInstance();
        LazySingLeton.getInstance();
        LazySingLeton.getInstance();
    }
}
