package com.jimmie.test.线程.阻塞;

import java.util.concurrent.locks.LockSupport;

public class BlockTest2 {

	public static void main(String[] args) throws Exception{

		SynFunction synFunction = new SynFunction();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {

				synFunction.fun();
			}
		});
		
		t1.start();


		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {

				synFunction.fun();
			}
		});

		t2.start();

		System.out.println("中断正在等待获取锁的线程，然后并没有什么卵用");
		t2.interrupt();
		
		System.in.read();
	}
}
