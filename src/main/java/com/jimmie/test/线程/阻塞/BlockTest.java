package com.jimmie.test.线程.阻塞;

import java.util.concurrent.locks.LockSupport;

public class BlockTest {

	public static void main(String[] args) throws Exception{
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<Integer.MAX_VALUE;i++){
					System.out.println("============i="+i);
					if(i==5){
						System.out.println("阻塞t1==========");
						LockSupport.park();
					}
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		
		t1.start();
	/*	
		Thread.sleep(1000);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("阻塞t1==========");
				LockSupport.park(t1);
				
			}
		}).start();;*/
		
		
		Thread.sleep(3000);
		
		System.out.println("唤醒t1=(两种方式)=========");
//		LockSupport.unpark(t1);
		t1.interrupt();
		System.in.read();
	}
}
