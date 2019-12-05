package com.jimmie.test.线程.status;

import java.io.IOException;

/**
 * @author jimmie
 * @create 2019-12-04 下午8:03
 */
public class T1 {

    public void fun1() throws InterruptedException {
        synchronized (this){
//            TimeUnit.SECONDS.sleep(100);
            wait();
            System.out.println("fun1 sleep over..");
        }
    }

    public synchronized void fun2(){
        System.out.println("fun2");
    }

    public static void main(String[] args) throws InterruptedException, IOException {

        T1 t1  = new T1();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t1.fun1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
               t1.fun2();
            }
        }).start();


        System.in.read();
        synchronized (t1){
            t1.notifyAll();
        }

    }
}
