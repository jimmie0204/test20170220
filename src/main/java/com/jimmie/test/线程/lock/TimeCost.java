package com.jimmie.test.线程.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class TimeCost implements Lock{  
	  
    private final Lock lock;
    
    private AtomicInteger count = new AtomicInteger(0);
      
    private AtomicLong sum= new AtomicLong(0);
    
    public TimeCost(Lock lock){  
        this.lock = lock;  
    }
    
    
      
    @Override  
    public void lock() {  
        long start = System.nanoTime();  
        lock.lock();  
        long duration = System.nanoTime() - start;  
//        System.out.println(lock.toString() + " time cost is " + duration + " ns");
        count.getAndIncrement();
        sum.addAndGet(duration);
    }  
    
    public void getAv(){
    	long costtime = sum.longValue()/count.longValue();
    	System.out.println(" time average cost is " + costtime + " ns");
    }
  
    @Override  
    public void unlock() {  
        lock.unlock();  
    }

	@Override
	public void lockInterruptibly() throws InterruptedException {
		lock.lockInterruptibly();
	}

	@Override
	public boolean tryLock() {
		return lock.tryLock();
	}

	@Override
	public boolean tryLock(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
		return lock.tryLock(paramLong, paramTimeUnit);
	}

	@Override
	public Condition newCondition() {
		return lock.newCondition();
	}  
  
}  