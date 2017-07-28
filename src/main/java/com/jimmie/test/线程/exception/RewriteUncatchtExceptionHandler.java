package com.jimmie.test.线程.exception;

public class RewriteUncatchtExceptionHandler implements Thread.UncaughtExceptionHandler{
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("我捕获到了线程池的异常");
    }
}