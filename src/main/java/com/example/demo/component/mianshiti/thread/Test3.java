package com.example.demo.component.mianshiti.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 如何确保三个线程顺序执行？【方法3】
 * 使用单个线程池[newSingleThreadExecutor]
 *
 * @author luoYong
 * @version 1.0
 * @date 2022/11/22 17:00
 */
public class Test3 {

    public static void main(String[] args) {
        final Thread t1 = new Thread(() -> System.out.println("thread start T1:"),"T1");
        final Thread t2 = new Thread(() -> System.out.println("thread start T2:"),"T2");
        final Thread t3 = new Thread(() -> System.out.println("thread start T3:"),"T3");

        //创建一个单线程化的线程池，以此保证线程顺序执行.
        ExecutorService executor = Executors.newSingleThreadExecutor();

        //执行线程
        executor.submit(t1);
        executor.submit(t2);
        executor.submit(t3);
        //关闭线程池
        executor.shutdown();
    }
}
