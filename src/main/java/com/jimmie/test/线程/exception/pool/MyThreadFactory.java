package com.jimmie.test.线程.exception.pool;

import java.util.concurrent.ThreadFactory;

import com.jimmie.test.线程.exception.RewriteUncatchtExceptionHandler;

public class MyThreadFactory implements ThreadFactory{
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setUncaughtExceptionHandler(new RewriteUncatchtExceptionHandler());
        System.out.println("Thread[" + t.getName() + "] created.");
        return t;
    }
}
