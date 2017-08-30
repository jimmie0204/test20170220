package com.jimmie.test.线程.缓存一致性;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class DD {

	
	public void testgg(){

		ReorderExample  example = new ReorderExample();

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
				example.writer();
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
				example.reader();
			}
		}).start();
		
	}
	
	public static void main(String[] args) {
		DD dd = new DD();
		AtomicInteger count = new AtomicInteger(0);

		ExecutorService ex = Executors.newCachedThreadPool();
		for(int i=0;i<2500;i++){
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
