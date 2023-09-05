package com.example.demo.component.javaDemo.JavaPackage;

import java.util.LinkedList;
import java.util.Queue;

class Consumer implements Runnable {
    private Queue<String> queue;

    public Consumer(Queue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) { // 当队列为空，消费者线程等待
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String message = queue.poll();
                System.out.println("consume: " + message);
                queue.notifyAll(); // 消费者线程消费完消息，唤醒所有等待队列的线程
            }
        }
    }


    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        int maxSize = 5;
        Thread producerThread = new Thread(new Producer(queue, maxSize));
        Thread consumerThread = new Thread(new Consumer(queue));
        producerThread.start();
        consumerThread.start();
    }
}
