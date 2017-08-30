package com.jimmie.test.线程.AQS;

import java.util.concurrent.Semaphore;

public class SemaphoreTest2 {
	public static void main(String[] args) throws Exception{
		Semaphore s = new Semaphore(10);
		 
		 new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					s.acquire(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+" 获得锁,目前锁可用数==="+s.availablePermits());
			}
		},"Thread-1").start();
		 
		 new Thread(new Runnable() {
				
			@Override
			public void run() {
				try {
					s.acquire(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+" 获得锁,目前锁可用数==="+s.availablePermits());
			}
		},"Thread-2").start();
		 
		 new Thread(new Runnable() {
				
			@Override
			public void run() {
				try {
					s.acquire(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+" 获得锁,目前锁可用数==="+s.availablePermits());
			}
		},"Thread-3").start();
		 
		 Thread.sleep(2000);
		 
		 new Thread(new Runnable() {
				
			@Override
			public void run() {
				s.release(2);
				System.out.println(Thread.currentThread().getName()+" 释放两个锁,目前锁可用数==="+s.availablePermits());
			}
		},"Thread-4").start();
	}

	
}
