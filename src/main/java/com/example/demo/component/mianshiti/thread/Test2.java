package com.example.demo.component.mianshiti.thread;

import java.util.concurrent.CountDownLatch;

/**
 * 如何确保三个线程顺序执行？【方法2】
 * 使用CountDownLatch
 *
 * @author luoYong
 * @version 1.0
 * @date 2022/11/22 16:43
 */
public class Test2 {

    public static void main(String[] args) {

        CountDownLatch c1 = new CountDownLatch(0);//计数器为0
        CountDownLatch c2 = new CountDownLatch(1);//计数器为1
        CountDownLatch c3 = new CountDownLatch(1);//计数器为1

        //t1的计数器c1为0，t1执行;t2的计数器减1
        Thread t1 = new Thread(new runThread(c1, c2));

        //t2的计数器c2为0时，t2执行;t3的计数器c3减1
        Thread t2 = new Thread(new runThread(c2, c3));

        //t3的计数器c3为0时，t3执行.
        Thread t3 = new Thread(new runThread(c3, c3));

        t1.start();
        t2.start();
        t3.start();
    }

    static class runThread implements Runnable {
        private CountDownLatch c1;
        private CountDownLatch c2;

        public runThread(CountDownLatch c1, CountDownLatch c2) {
            this.c1 = c1;
            this.c2 = c2;
        }

        @Override
        public void run() {
            try {
                //计数为0才可以执行
                c1.await();
                System.out.println("thread start:" + Thread.currentThread().getName());
                //后一线程计数器减少
                c2.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
