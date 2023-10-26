package com.example.demo.component.javaDemo.JavaPackage;

import java.util.concurrent.Semaphore;

class SemaphoreDemo implements Runnable {

    private Semaphore semaphore;
    private int n;

    public SemaphoreDemo(Semaphore semaphore, int n) {
        this.semaphore = semaphore;
        this.n = n;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire(); // 获取一个 permit
            for (int i = 0; i < n; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); // 释放一个 permit
        }
    }


    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        int n = 5;
        for (int i = 0; i < 5; i++) {
            new Thread(new SemaphoreDemo(semaphore, n)).start(); // 同时运行 2 个线程
        }
    }
}
