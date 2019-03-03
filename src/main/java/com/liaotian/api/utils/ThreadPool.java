package com.liaotian.api.utils;

import java.util.concurrent.*;

/**
 * Executors 自带
 */
public class ThreadPool {

    /**
     * 线程数目固定
     * @param nThreads
     * @return
     */
    public static ExecutorService newFixThreadPool(int nThreads){
        return Executors.newFixedThreadPool(nThreads);
    }

    /**
     * 缓冲线程池
     * @return
     */
    public static ExecutorService newCachedThreadPool(){
        return Executors.newCachedThreadPool();
    }

    /**
     * 单一线程
     * @return
     */
    public static ExecutorService newSingleThreadPool(){
        return Executors.newSingleThreadExecutor();
    }

    /**
     * 定时功能
     * @param corePoolSize
     * @return
     */
    public static ExecutorService newScheduledThreadPool(int corePoolSize){
        return Executors.newScheduledThreadPool(corePoolSize);
    }
}

