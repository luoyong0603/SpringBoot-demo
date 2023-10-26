package com.example.demo.component.javaDemo.JavaPackage;

import java.util.Queue;

class Producer implements Runnable {
    private Queue<String> queue;
    private int maxSize;
    private int i = 0;

    public Producer(Queue<String> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.size() == maxSize) { // 当队列满了，生产者线程等待
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.offer("message" + (++i));
                System.out.println("produce: " + i);
                queue.notifyAll(); // 生产者线程生产完消息，唤醒所有等待队列的线程
            }
        }
    }
}