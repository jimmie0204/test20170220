package com.jimmie.test.线程.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

	private  TimeCost lock;

	private volatile int value = 0;

	public void method() {
		if(lock==null)
			System.out.println("Value: " + ++value);
		else{
			lock.lock();
			System.out.println("Value: " + ++value);
			lock.unlock();
		}

	}
	
	public TimeCost getLock(){
		return lock;
	}
	
	public LockTest setLock(Lock lock){
		if(lock!=null)
			this.lock = new TimeCost(lock);
		else
			this.lock=null;
		return this;
	}

	public static void main(String[] args) {
		final LockTest locktest = new LockTest();
		
		locktest
		.setLock(new ReentrantLock())
		.setLock(null)
		.setLock(new CLHLock2());
//		.setLock(new CaseLock());
		
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(new Runnable() {

				@Override
				public void run() {
					locktest.method();
				}

			});
			t.start();
		}
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TimeCost lock2 = locktest.getLock();
		if(lock2!=null)
			lock2.getAv();
		
	}
}
