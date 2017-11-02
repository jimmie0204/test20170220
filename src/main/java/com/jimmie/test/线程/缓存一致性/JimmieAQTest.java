package com.jimmie.test.线程.缓存一致性;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class JimmieAQTest {
	
	static final int N=3;
	public static volatile int a=0;
	

	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService ex = Executors.newCachedThreadPool();
		CyclicBarrier barrier = new CyclicBarrier(N);
		
		for(int i=0;i<N;i++){
			ex.submit(new Runnable() {
				
				@Override
				public void run() {
					
					try {
						TimeUnit.SECONDS.sleep(new Random().nextInt(1));
						barrier.await();
						System.out.println("wake...................");
						a++;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			
		}

			
		
		
		TimeUnit.SECONDS.sleep(2);
		
		System.out.println("a==="+a);

	}

}
