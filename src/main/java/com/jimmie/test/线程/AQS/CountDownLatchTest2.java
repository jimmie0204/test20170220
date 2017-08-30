package com.jimmie.test.线程.AQS;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest2 {
	public static void main(String[] args) throws Exception{
		CountDownLatch s = new CountDownLatch(1);
		 
		 new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					s.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+" 获得锁,目前锁可用数==="+s.getCount());
			}
		},"Thread-1").start();
		 
		 new Thread(new Runnable() {
				
			@Override
			public void run() {
				try {
					s.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+" 获得锁,目前锁可用数==="+s.getCount());
			}
		},"Thread-2").start();
		 
		 new Thread(new Runnable() {
				
			@Override
			public void run() {
				try {
					s.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+" 获得锁,目前锁可用数==="+s.getCount());
			}
		},"Thread-3").start();
		 
		 Thread.sleep(2000);
		 
		 new Thread(new Runnable() {
				
			@Override
			public void run() {
				s.countDown();
				System.out.println(Thread.currentThread().getName()+" 释放锁,目前锁可用数==="+s.getCount());
			}
		},"Thread-4").start();
	}

	
}
