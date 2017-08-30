package com.jimmie.test.线程.缓存一致性;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SingleTonTest {
	public static  AtomicInteger count = new AtomicInteger(0);
	public static CyclicBarrier barrier = new CyclicBarrier(1);
	

	public static void main(String[] args) {
		ExecutorService ex = Executors.newCachedThreadPool();
		for(int i=0;i<1;i++){
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
					System.out.println(Sington.getInstance());
				}
			});
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ex.shutdown();
	}
	
}