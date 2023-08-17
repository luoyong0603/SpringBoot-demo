package com.example.demo.component.threadPool;

import java.util.concurrent.*;

/**
 * 使用CountDownLatch
 */
public class CountDownLatchTask {

    //创建一个最大线程数100的线程池
    private static ExecutorService es =
            new ThreadPoolExecutor(4, 100, 0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<Runnable>(100));

    public static void main(String[] args) throws Exception {
        //计数器，判断线程是否执行结束
        //初始值为10
        CountDownLatch taskLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            es.execute(() -> { //提交执行
                taskLatch.countDown();
                System.out.println("当前计数器值为：" + taskLatch.getCount());
                try {
                    //模拟线程执行方法，执行1s
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        //当前线程阻塞，等待计数器置为0
        taskLatch.await();
        System.out.println("线程池执行完了！");
    }


}
