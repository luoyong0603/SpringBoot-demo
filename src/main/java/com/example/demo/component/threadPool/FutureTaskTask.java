package com.example.demo.component.threadPool;

/**
 * @author luoYong
 * @version 1.0
 * @date 2023/8/14 15:11
 */

import java.util.concurrent.*;

/**
 * 使用 FutrueTask 等待线程池执行完全部任务
 */
public class FutureTaskTask {

    //创建一个最大线程数100的线程池
    private static ExecutorService es =
            new ThreadPoolExecutor(4, 100, 0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<Runnable>(100));

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 创建任务1
        FutureTask<Integer> task1 = new FutureTask<>(() -> {
            System.out.println("---Task 1 开始执行---");
            Thread.sleep(2000);
            System.out.println("------Task 1 执行结束------");
            return 1;
        });
        // 创建任务2
        FutureTask<Integer> task2 = new FutureTask<>(() -> {
            System.out.println("---Task 2 开始执行---");
            Thread.sleep(3000);
            System.out.println("------Task 2 执行结束------");
            return 2;
        });
        // 创建任务3
        FutureTask<Integer> task3 = new FutureTask<>(() -> {
            System.out.println("---Task 3 开始执行---");
            Thread.sleep(1000);
            System.out.println("------Task 3 执行结束------");
            return 3;
        });
        // 创建任务4
        FutureTask<Integer> task4 = new FutureTask<>(() -> {
            System.out.println("---Task 4 开始执行---");
            Thread.sleep(500);
            System.out.println("------Task 4 执行结束------");
            return 4;
        });
        // 提交4个任务给线程池
        es.submit(task1);
        es.submit(task2);
        es.submit(task3);
        es.submit(task4);

        // 等待所有任务执行完毕
        task1.get();
        task2.get();
        task3.get();
        task3.get();

        //执行完毕
        System.out.println("线程池执行完了！");
    }
}
