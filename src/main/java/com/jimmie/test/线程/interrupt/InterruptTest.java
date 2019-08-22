package com.jimmie.test.线程.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @author jimmie
 * @create 2019-05-08 上午11:38
 */
public class InterruptTest {

    public static void main(String[] args) throws Exception {

        /*Thread t = new Thread(() -> {
            System.out.println("sdsdsd");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("被中断抛异常结束");
            }
        });

        t.start();
        TimeUnit.SECONDS.sleep(5);
        t.interrupt();*/


        Job job = new Job();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    job.task();
                } catch (InterruptedException e) {
                    System.out.println("被中断抛异常结束"+Thread.currentThread().getName());
                }
            }
        });
        System.out.println(t2.getName());
        System.out.println("t2线程中断状态为=="+t2.isInterrupted()+"===线程状态为=="+t2.getState().name());
        t2.start();
        System.out.println("t2线程中断状态为=="+t2.isInterrupted()+"===线程状态为=="+t2.getState().name());

        TimeUnit.SECONDS.sleep(5);
        System.out.println("t2线程中断状态为=="+t2.isInterrupted()+"===线程状态为=="+t2.getState().name());

        job.add();//不中断测试
//        t2.interrupt();//中断测试
        System.out.println("t2线程中断状态为=="+t2.isInterrupted()+"===线程状态为=="+t2.getState().name());


        TimeUnit.SECONDS.sleep(5);
        System.out.println("t2线程中断状态为=="+t2.isInterrupted()+"===线程状态为=="+t2.getState().name());

        System.in.read();



    }




}
