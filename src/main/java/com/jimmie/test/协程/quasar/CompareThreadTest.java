package com.jimmie.test.协程.quasar;

import java.util.concurrent.TimeUnit;

/**
 * @author jimmie
 * @create 2019-11-27 下午3:05
 */
public class CompareThreadTest {

    public static void main(String[] args){
        Thread thread1 = new ThreadTask("hello");
        Thread thread2 = new ThreadTask("world");

        thread1.start();
        thread2.start();
       /* try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

    }


}

class ThreadTask extends Thread {
    private String msg;

    public ThreadTask(String msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(msg);
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
