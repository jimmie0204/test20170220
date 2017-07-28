package com.jimmie.test.线程.lock;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import com.jimmie.test.线程.lock.CLHLock.QNode;  

/** 

* 如果下一个线程没有加入队列，会有越界问题
 * **/  
public class CLHLock2 implements Lock{  
    // 原子变量指向队尾  
    private AtomicInteger tail;  
    
    private volatile List<QNode> list = new LinkedList<>();
    
    // 两个指针，一个指向自己的Node,一个指向前一个Node  
    ThreadLocal<QNode> myNode = new ThreadLocal<QNode>(){  
        protected QNode initialValue(){  
            return new QNode();  
        }  
    };  
    
    ThreadLocal<Integer> point = new ThreadLocal<Integer>(){  
        protected Integer initialValue() {  
            return 0;  
     }  
};
      
    public CLHLock2(){
    	QNode qNode = new QNode();
    	qNode.lock=true;
    	list.add(qNode);
        tail = new AtomicInteger(0);  
    }  
      
    @Override  
    public void lock() {  
    	 QNode node = myNode.get();  
         list.add(node);
    	int andIncrement = tail.getAndIncrement();
    	QNode watchQnode = list.get(andIncrement);

    	point.set(andIncrement);
        while(!watchQnode.lock){  
//        	 System.out.println(Thread.currentThread().getName()+"is circling...");
        }  
    }  
  
    @Override  
    public void unlock() {  

    	Integer integer = point.get();
    	QNode watchQnode = list.get(integer);
    	watchQnode.lock = false;
    	if(tail.get()-integer==1)
    		return ;
    	QNode watchQnode2 = list.get(integer+1);//越界
    	watchQnode2.lock=true;
    }  
    
    public static class QNode {  
        volatile boolean lock;  
    }  
      
  
        public String toString(){  
           return "CLHLock";  
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