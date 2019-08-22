package com.jimmie.test.线程.interrupt;

/**
 * @author jimmie
 * @create 2019-05-08 上午11:50
 */
public class Job {
    int count = 0;

    public void task() throws InterruptedException {
        System.out.println("执行任务===" + Thread.currentThread().getName());
        synchronized (this) {
            if (count == 0) {
                System.out.println("count为0阻塞===" + Thread.currentThread().getName());
                wait();//让出锁
            }
            System.out.println(count + "==唤醒之后===" + Thread.currentThread().getName());
        }
    }

    public void add() {
//        System.out.println("执行任务===" + Thread.currentThread().getName());
        synchronized (this) {
            if (count == 0) {
                count++;
                notifyAll();
            }
        }
    }

    public void printMyThread(){
        System.out.println("执行我的线程是===" + Thread.currentThread().getName());
    }
}