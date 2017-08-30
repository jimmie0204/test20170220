package com.jimmie.test.线程.缓存一致性;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ACass {
	public static  AtomicInteger count = new AtomicInteger(0);
	private int a = 0;

	public void increase() {
		a++;
		if(a==500)
			System.out.println(Thread.currentThread().getName()+"====="+a);
	}
	
	public void writer2() {
		setA(2);
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public static void main(String[] args) {
		ACass ac = new ACass();
		ExecutorService ex = Executors.newCachedThreadPool();
		for(int i=0;i<500;i++){
			ex.submit(new Runnable() {
				
				@Override
				public void run() {
					ac.increase();
				}
			});
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("a=="+ac.getA());
		ex.shutdown();
	}
	
}