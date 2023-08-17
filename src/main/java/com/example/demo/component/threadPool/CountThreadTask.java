package com.example.demo.component.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author luoYong
 * @version 1.0
 * @date 2023/8/11 16:24
 */


public class CountThreadTask {

    //创建一个最大线程数100的线程池
    private static ExecutorService es =
            new ThreadPoolExecutor(3, 100, 0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<Runnable>(100));

    public static void main(String[] args) throws Exception {
        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            es.execute(() -> { //提交执行
                System.out.println("线程" + finalI + "执行完成！");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        ThreadPoolExecutor threadPool = ((ThreadPoolExecutor) es);
        System.out.println("线程池任务总数量："+threadPool.getTaskCount());
        System.out.println("---------线程池开始执行-----------");
        while (true) {
            if (threadPool.getTaskCount() == threadPool.getCompletedTaskCount()) {
                System.out.println("---------线程池执行完了-----------");
                break;
            }
            //间隔2s查询一次
            Thread.sleep(2000);
            System.out.println("线程池还未执行完，敬请等待！已完成的任务数量："+threadPool.getCompletedTaskCount());
        }

    }

}
