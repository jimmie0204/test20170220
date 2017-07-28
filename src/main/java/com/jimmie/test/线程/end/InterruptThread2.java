package com.jimmie.test.线程.end;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 通过SocketException异常中断阻塞线程.
 * @version V1.0 ,2011-4-17
 * @author xiahui
 */
public class InterruptThread2 extends Thread {
    volatile boolean stop = false;
    volatile ServerSocket socket;

    public void run() {
        try {
            socket = new ServerSocket(7856);
        } catch (IOException e) {
            System.out.println("Could not create the socket...");
            return;
        }
        while (!stop) {
            System.out.println("Waiting for connection...");
            try {
                Socket sock = socket.accept();
            } catch (IOException e) {
                System.out.println("accept() failed or interrupted...");
            }
        }
        System.out.println("Thread exiting under request...");
    }

    public static void main(String args[]) throws Exception {
        InterruptThread2 thread = new InterruptThread2();
        System.out.println("Starting thread...");
        thread.start();
        Thread.sleep(3000);
        System.out.println("Asking thread to stop...");
        
        /*由于线程处理阻塞状态，interrupt不产生任何作用*/
//        System.out.println( "Interrupting thread..." );
//        thread.interrupt();
       
        thread.stop = true;
        thread.socket.close();
        Thread.sleep(3000);
        System.out.println("Stopping application...");

    }
}