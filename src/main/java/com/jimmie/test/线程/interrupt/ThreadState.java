package com.jimmie.test.线程.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @author jimmie
 * @create 2019-05-08 下午12:11
 */
public class ThreadState {

    public static void main(String[] args) throws Exception {

        Thread t2  = new Thread(() -> {
            System.out.println("线程执行");
        });
        System.out.println("t2线程中断状态为=="+t2.isInterrupted()+"===线程状态为=="+t2.getState().name());
        t2.start();
        System.out.println("t2线程中断状态为=="+t2.isInterrupted()+"===线程状态为=="+t2.getState().name());
        TimeUnit.SECONDS.sleep(5);
        System.out.println("t2线程中断状态为=="+t2.isInterrupted()+"===线程状态为=="+t2.getState().name());
        TimeUnit.SECONDS.sleep(5);
        System.out.println("t2线程中断状态为=="+t2.isInterrupted()+"===线程状态为=="+t2.getState().name());

        System.in.read();

    }
}
