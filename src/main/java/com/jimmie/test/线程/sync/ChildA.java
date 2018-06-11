package com.jimmie.test.线程.sync;/**
 * Created by jimmie on 2018/6/11.
 */

import java.util.concurrent.TimeUnit;

/**
 * @author jimmie
 * @create 2018-06-11 下午3:49
 */

public class ChildA extends Parent{


    public void childPrint() throws InterruptedException {
        super.print();
        System.out.println("子打印结束。。");
    }

    public void childPrint2() throws InterruptedException {
        super.print2();
        System.out.println("子打印2结束。。");
    }

    public void print() throws InterruptedException {
        System.out.println("即将进入锁区");
        synchronized (obj) {
            System.out.println("进入锁区，打印日志");
            TimeUnit.SECONDS.sleep(5);
            System.out.println("结束");
        }
    }

    //复写该方法之后，需要显式标识该方法是同步方法才能起作用，不能继承父类，如果不复写该方法，直接调用父类则是同步方法
    public void print2() throws InterruptedException {
        System.out.println("进入锁区，打印日志");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("结束");

    }

}
