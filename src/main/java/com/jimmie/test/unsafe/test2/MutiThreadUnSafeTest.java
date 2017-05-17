package com.jimmie.test.unsafe.test2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MutiThreadUnSafeTest{
	
	public static void main(String[] args) {
		 CyclicBarrier barrier = new CyclicBarrier(10);
		ExecutorService exc = Executors.newFixedThreadPool(10);
		MyUnSafeTest unTest = new MyUnSafeTest();
		
		for(int i=0;i<10;i++){
			exc.execute(new Runnable() {
				
				@Override
				public void run() {
					int old;
					int newValue;
					int count = 0;
					 do{
						 System.out.println(Thread.currentThread().getName()+"重试**********"+count+"次");
						 old = unTest.get();
						 newValue = old+1;
						 count++;
	                  }while (!unTest.compareAndSet(old, newValue));
					 
					 try {
						 System.out.println("wating==="+barrier.getNumberWaiting());
						barrier.await();
						
					} catch (InterruptedException | BrokenBarrierException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 return ;
				}
			});
		}
		
		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("OVER==========="+unTest.get());
	}
}