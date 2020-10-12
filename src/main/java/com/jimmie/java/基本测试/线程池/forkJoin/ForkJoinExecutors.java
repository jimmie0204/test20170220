package com.jimmie.java.基本测试.线程池.forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @author jimmie
 * @create 2020-08-05 下午4:02
 */
public class ForkJoinExecutors {

    private static ForkJoinPool forkJoinPool = new ForkJoinPool();

    public static ForkJoinTask<?> submitTask(ForkJoinTask forkJoinTask){
        ForkJoinTask<Integer> reslut = forkJoinPool.submit(forkJoinTask);
        return reslut;
    }
}
