package com.jimmie.test.线程.缓存一致性;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SingleTon2Test {
	public static  AtomicInteger count = new AtomicInteger(0);
	public static CyclicBarrier barrier = new CyclicBarrier(5000);
	

	public static void main(String[] args) {
		Sington2 s2 = new Sington2();
		ExecutorService ex = Executors.newCachedThreadPool();
		for(int i=0;i<5000;i++){
			ex.submit(new Runnable() {
				
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
					s2.increase();
				}
			});
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(s2.getCount());
		ex.shutdown();
	}
	
}