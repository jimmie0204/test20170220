package com.jimmie.java.基本测试.集合类;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class LinkedBlockingQueueTest {

    static LinkedBlockingQueue<String> list = new LinkedBlockingQueue<String>();
    
   private static ExecutorService exec = Executors.newCachedThreadPool();
   
	private static AtomicInteger num = new AtomicInteger(0);
	
	/** 启动的服务个数 */
	private static final int CLIENT_QTY = 1000;
   
   private static class AddThread extends Thread{
	   
	   @Override
		public void run(){
		   list.add(num+"");
	   }
   }
   
	public static void main(String[] args) throws InterruptedException {
		   for(int i=0;i<CLIENT_QTY;i++){
               int data = num.incrementAndGet();
               exec.submit(new AddThread());
//               Thread.sleep(2000);//如果不加这一句，则并发很高，zk的监听无法响应这么多变化
        }
		   
		   Thread.sleep(10000);
	        System.out.println("num---"+num);
	        System.out.println("list---"+list.size());//此次run节点被更新的次数
	}

}
