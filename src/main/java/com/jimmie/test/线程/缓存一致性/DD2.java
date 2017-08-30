package com.jimmie.test.线程.缓存一致性;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class DD2 {

	
	public void testgg(){

		ReorderExample2  example = new ReorderExample2();
		CyclicBarrier barrier = new CyclicBarrier(2);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					barrier.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				example.func1();
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					barrier.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				example.func2();
			}
		}).start();
		
	try {
		Thread.sleep(500);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	example.print();
	
	}
	
	public static void main(String[] args) {
		
		DD2 dd = new DD2();
		AtomicInteger count = new AtomicInteger(0);
		ExecutorService ex = Executors.newCachedThreadPool();
		for(int i=0;i<3000;i++){
			ex.submit(new Runnable() {
				
				@Override
				public void run() {
					count.incrementAndGet();
					dd.testgg();
				}
			});
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("===================finish==================count========"+count);
		ex.shutdown();
	}
}
