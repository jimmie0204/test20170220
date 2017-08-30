package com.jimmie.test.线程.缓存一致性;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class ReorderExample {
	int a = 0;
	boolean flag = false;

	public void writer() {
		flag = true; // 2
		a = 1; // 1
		
	}

	public void reader() {
		int i = -1;
		if (flag) { // 3
			i = a * a; // 4
		}
		System.out.println("over"+"======"+i);
		if(i==0)
			System.out.println("出现i=0的情况==================================");
	}
	
	
	public static void main(String[] args) {
		
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
}