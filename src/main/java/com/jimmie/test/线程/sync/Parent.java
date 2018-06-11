package com.jimmie.test.线程.sync;/**
 * Created by jimmie on 2018/6/11.
 */

import java.util.concurrent.TimeUnit;

/**
 * @author jimmie
 * @create 2018-06-11 下午3:46
 */

public class Parent {

    public Object obj = new Object();


    public void print() throws InterruptedException {
        System.out.println("即将进入锁区");
        synchronized (obj) {
            System.out.println("进入锁区，打印日志");
            TimeUnit.SECONDS.sleep(5);
            System.out.println("结束");
        }
    }

    public synchronized void print2() throws InterruptedException {
        System.out.println("进入锁区，打印日志");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("结束");

    }
}
