package com.jimmie.test.线程.exception;

public class Task implements Runnable {
    public void run() {
        System.out.println("执行任务");
        int num  = Integer.parseInt("TT");
    }
}