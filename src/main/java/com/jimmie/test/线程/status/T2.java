package com.jimmie.test.线程.status;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author jimmie
 * @create 2019-12-04 下午8:03
 */
public class T2 {

    public int count = 0;

    public void fun1() throws InterruptedException {
        synchronized (this){
            count++;
            TimeUnit.SECONDS.sleep(10);//不释放锁
//            wait();//释放锁
            System.out.println("fun1 sleep over..");
        }
    }

    public synchronized void fun2(){
        System.out.println("fun2  count="+count);
    }
    public void fun3(){
        System.out.println("fun3  count="+count);
    }


    public static void main(String[] args) throws InterruptedException, IOException {

        T2 t1  = new T2();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t1.fun1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();

//        thread1.join();
//        TimeUnit.SECONDS.sleep(1);


        new Thread(new Runnable() {
            @Override
            public void run() {
               t1.fun3();
            }
        }).start();


        System.in.read();
        synchronized (t1){
            t1.notifyAll();
        }

    }
}
