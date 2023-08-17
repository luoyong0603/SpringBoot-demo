package com.example.demo.component.threadPool;

import java.util.concurrent.*;

/**
 * 使用isTerminated()
 */
public class IsTerminatedTask {

    //创建一个最大线程数100的线程池
    private static ExecutorService es =
            new ThreadPoolExecutor(4, 100, 0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<Runnable>(100));

    public static void main(String[] args) throws Exception {

        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            es.execute(() -> { //提交执行
                System.out.println("线程" + finalI + "执行完成！");
                try {
                    //模拟线程执行过程
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        //关闭线程池
        es.shutdown();
        //隔间1s判断是否执行完了，如果所有任务在关闭后完成,返回true。
        while (!es.isTerminated()) {
            Thread.sleep(1000);
        }
        System.out.println("---------线程池执行完了-----------");
    }
}