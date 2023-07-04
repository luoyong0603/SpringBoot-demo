package com.example.demo.component.mianshiti.thread;

/**
 * 如何确保三个线程顺序执行？【方法1】
 * 使用join方法
 *
 * @author luoYong
 * @version 1.0
 * @date 2022/11/22 15:29
 */
public class Test1 {

    // T1、T2、T3三个线程顺序执行
    public static void main(String[] args) {
        Thread t1 = new Thread(new runThread(null));
        Thread t2 = new Thread(new runThread(t1));
        Thread t3 = new Thread(new runThread(t2));
        t1.start();
        t2.start();
        t3.start();
    }

    static class runThread implements Runnable {
        //上一个线程
        private Thread beforeThread;

        //构造赋值
        public runThread(Thread beforeThread) {
            this.beforeThread = beforeThread;
        }

        //线程执行。
        public void run() {
            //保证第一个线程执行。
            if (beforeThread != null) {
                try {
                    //执行join()，合并为顺序执行的线程。
                    beforeThread.join();
                    System.out.println("thread start:" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("thread start:" + Thread.currentThread().getName());
            }
        }
    }
}
