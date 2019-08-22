package com.jimmie.test.线程.exception;


/**
 * 对于run中抛出的异常，如果没有捕获处理，二十向外抛出，就不会被其他方法捕获直接在控制台打出，叫做异常逃逸，
 * 为了解决这个问题，线程定义了异常处理类，当异常抛出时，会被这个类处理。
 */
public class Task implements Runnable {
    public void run() {
        try {
            System.out.println("执行任务");
            int num  = Integer.parseInt("TT");
        } catch (Exception e) {
            System.out.println("任务内部捕获到异常");
//            throw e; //异常逃逸
        }

    }
}