package com.liaotian.api.utils;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义无阻塞线程池
 */
public class CustomThreadPoolExecutor {
    private ThreadPoolExecutor poolExecutor = null;

    //核心线程池数目
    private static int corePoolSize = 10;
    //最大线程池数目
    private static int maximumPoolSize = 30;
    //超过corePoolSize数目的空闲线程最大存活时间
    private static int keepAliveTime = 30;
    //keepAliveTime时间单位
    private static TimeUnit timeUnits = TimeUnit.SECONDS;
    //阻塞队列
    private static int workQueue = 10;


    public void init() {
        poolExecutor = new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                timeUnits,
                new ArrayBlockingQueue<>(workQueue),
                new CustomThreadFactory(),
                new CustomRejectedExecutionHandler());
    }

    public void destory() {
        if (poolExecutor == null) {
            poolExecutor.shutdownNow();
        }
    }

    public ExecutorService getCustomThreadPoolExecutor() {
        return poolExecutor;
    }
}


class CustomThreadFactory implements ThreadFactory {

    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        String threadName = CustomThreadPoolExecutor.class.getSimpleName() + count.addAndGet(1);
        thread.setName(threadName);
        return thread;
    }
}

class CustomRejectedExecutionHandler implements RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("error is at " + r);
        System.out.println("error is at " + executor);
        new RejectedExecutionException();
        System.out.println(new RejectedExecutionException());
    }
}