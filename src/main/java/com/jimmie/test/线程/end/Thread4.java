package com.jimmie.test.线程.end;

/**
 * 程序演示的是子线程通知父线程别等它了
 * @author Jimmie
 *
 */
public class Thread4 extends Thread {
    private Thread parent;
    public Thread4(Thread parent){
        this.parent = parent;
    }
    
    public void run() {
        while (true) {
            System.out.println("sub thread is running...");
            long now = System.currentTimeMillis();
            while (System.currentTimeMillis() - now < 2000) {
                // 为了避免Thread.sleep()而需要捕获InterruptedException而带来的理解上的困惑,
                // 此处用这种方法空转2秒
            }
            System.out.println("trying end parent thread !==="+parent.isInterrupted());
            parent.interrupt();
            System.out.println("ended parent thread !==="+parent.isInterrupted());
        }
    }
    
    public static void main(String[] args){
        Thread4 t = new Thread4(Thread.currentThread());
        t.start();
        try {
        	long now = System.currentTimeMillis();
        	 while (System.currentTimeMillis() - now < 5000) {
                 // 为了避免Thread.sleep()而需要捕获InterruptedException而带来的理解上的困惑,
                 // 此处用这种方法空转2秒
             }
            t.join();
            System.out.println("child thread ended!===");
            System.out.println("main end");
        } catch (InterruptedException e) {
            System.out.println("Parent thread will die...");
        }
    }
}