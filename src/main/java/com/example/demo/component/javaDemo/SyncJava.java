package com.example.demo.component.javaDemo;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SyncJava {

    //初始为0
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized void decrement() {
        count--;
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        SyncJava sync = new SyncJava();
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 1000; i++) {
            executor.execute(() -> {
                sync.increment();
                sync.decrement();
            });
        }

        //关闭线程池
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println(sync.getCount());
    }
}
