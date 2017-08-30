package com.jimmie.test.线程.status;

import java.util.concurrent.locks.LockSupport;

public class InterruptTest {



	public static void main(String[] args) throws Exception{
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<Integer.MAX_VALUE;i++){
					System.out.println("============i="+i);
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

		
		Thread.sleep(1000);
		
		System.out.println("中断t1=()=========");
		t1.interrupt();
		System.in.read();
	}

}
