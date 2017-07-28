package com.jimmie.test.线程.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;  

/** 
 * 有界队列锁，使用一个volatile数组来组织线程 
 * 缺点是得预先知道线程的规模n，所有线程获取同一个锁的次数不能超过n 
 * 假设L把锁，那么锁的空间复杂度为O(Ln) 
 * **/  
public class ArrayLock implements Lock{  
    // 使用volatile数组来存放锁标志， flags[i] = true表示可以获得锁  
    private volatile boolean[] flags;  
      
    // 指向新加入的节点的后一个位置  
    private AtomicInteger tail;  
      
    // 总容量  
    private final int capacity;  
      
    private ThreadLocal<Integer> mySlotIndex = new ThreadLocal<Integer>(){  
         protected Integer initialValue() {  
                return 0;  
         }  
    };  
      
    public ArrayLock(int capacity){  
        this.capacity = capacity;  
        flags = new boolean[capacity];  
        tail = new AtomicInteger(0);  
        // 默认第一个位置可获得锁  
        flags[0] = true;  
    }  
      
    @Override  
    public void lock() {  
        int slot = tail.getAndIncrement() % capacity;  
        mySlotIndex.set(slot);  
        // flags[slot] == true 表示获得了锁， volatile变量保证锁释放及时通知  
         while(!flags[slot]){  
//              System.out.println(Thread.currentThread().getName()+"is circling...");
         }  
         
     }  
  
     @Override  
     public void unlock() {  
           int slot = mySlotIndex.get();  
           flags[slot] = false;  
           flags[(slot + 1) % capacity] = true;  
    }  
        public String toString(){  
           return "ArrayLock";  
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
		public Condition newCondition() {
			// TODO Auto-generated method stub
			return null;
		}  
}