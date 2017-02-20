package com.jimmie.test.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockTest2 {

	final Lock lock1 = new ReentrantLock();
	
	private ReadWriteLock lock = new ReentrantReadWriteLock();
	
	final Lock readlock = lock.readLock();
	
	final Lock writelock = lock.writeLock();
	
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
		}
	}
	
	public void print2(){
		try {
			readlock.lock();
			System.out.println("print2 printing....");
			Thread.sleep(10000);
			System.out.println("print2 printioverng....");
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			readlock.unlock();
		}
	}
	
	public static void main(String[] args) {
		final LockTest2 test = new LockTest2();
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
