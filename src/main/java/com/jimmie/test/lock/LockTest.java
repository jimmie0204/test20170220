package com.jimmie.test.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

	final Lock lock1 = new ReentrantLock();
	
	final Lock lock2 = new ReentrantLock();
	
	public void print1(){
		try {
			lock1.lock();
			System.out.println("print1 printing....");
			Thread.sleep(10000);
			System.out.println("print1 printioverng....");
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			lock1.unlock();
//			lock1.unlock();//报错
		}
	}
	
	public void print2(){
		try {
			lock1.lock();
			System.out.println("print2 printing....");
			Thread.sleep(10000);
			System.out.println("print2 printioverng....");
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			lock1.unlock();
		}
	}
	
	public static void main(String[] args) {
		final LockTest test = new LockTest();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				test.print1();
				
			}
		}).start();
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				test.print2();
				
			}
		}).start();;
	}
}
