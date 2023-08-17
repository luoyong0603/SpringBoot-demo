package com.example.demo.component.threadPool;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 使用CyclicBarrier
 */
public class CyclicBarrierTask {

    //创建一个最大线程数100的线程池
    private static ExecutorService es =
            new ThreadPoolExecutor(5, 100, 0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<Runnable>(100));

    public static void main(String[] args) throws InterruptedException {

        //任务总数
        final int taskCount = 5;
        //循环计数器
        CyclicBarrier cyclicBarrier = new CyclicBarrier(taskCount, new Runnable() {
            @Override
            public void run() {
                // 线程池执行完
                System.out.println("---------线程池执行完了-----------");
            }
        });

        // 添加任务
        for (int i = 0; i < taskCount; i++) {
            final int finalI = i;
            es.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        //随机休眠1-4秒
                        TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                        System.out.println("任务" + finalI + "执行完成");
                        // 线程执行完
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}