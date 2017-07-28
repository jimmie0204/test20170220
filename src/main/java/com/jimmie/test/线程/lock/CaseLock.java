package com.jimmie.test.线程.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class CaseLock implements Lock{

	private AtomicBoolean lock = new AtomicBoolean(false);
	
	@Override
	public void lock() {
		while(!lock.compareAndSet(false, true)){
//			System.out.println(Thread.currentThread().getName()+"is circling...");
		}
		
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean tryLock() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tryLock(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void unlock() {
		lock.compareAndSet(true, false);
	}

	@Override
	public Condition newCondition() {
		// TODO Auto-generated method stub
		return null;
	}

}
