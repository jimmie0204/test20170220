package com.jimmie.test.线程.threadLocal;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: yanxuxin
 * Date: Dec 14, 2009
 * Time: 9:26:41 PM
 */
public class ThreadLocalSample extends Thread {
    private OperationSample operationSample;

    public ThreadLocalSample(OperationSample operationSample) {
        this.operationSample = operationSample;
    }

    @Override
    public void run() {
        operationSample.printAndIncrementNum();
    }

    public static void main(String[] args) {

        final OperationSample operation = new OperationSample3();//The shared Object for threads.

        for (int i = 0; i < 5; i++) {
            new ThreadLocalSample(operation).start();
        }
    }
}

class OperationSample1 implements OperationSample{
    private int num;

    public synchronized void printAndIncrementNum() {
//    public void printAndIncrementNum() {
        for (int i = 0; i < 2; i++) {
            System.out.println(Thread.currentThread().getName() + "[id=" + num + "]");
            num += 10;
        }
    }
}

class OperationSample2 implements OperationSample {

    private static ThreadLocal<Integer> threadArg = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public void printAndIncrementNum() {
        for (int i = 0; i < 2; i++) {
            int num = threadArg.get();
            threadArg.set(num + 10);
            System.out.println(Thread.currentThread().getName() + "[id=" + num + "]");
        }
    }
}

class OperationSample3 implements OperationSample {

    private static final AtomicInteger uniqueId = new AtomicInteger(0);
    private static ThreadLocal<Integer> threadArg = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return uniqueId.getAndIncrement();
        }
    };

    public void printAndIncrementNum() {
        for (int i = 0; i < 2; i++) {
            int num = threadArg.get();
            threadArg.set(num + 10);
            System.out.println(Thread.currentThread().getName() + "[id=" + num + "]");
        }
    }
}