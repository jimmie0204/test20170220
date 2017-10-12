package com.jimmie.test.队列disruptor.multi;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.ExceptionHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SequenceBarrier;
import com.lmax.disruptor.WorkerPool;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.ProducerType;

public class Main {
	
	public static void main(String[] args) throws Exception {

		//创建ringBuffer
		RingBuffer<Order> ringBuffer = 
				RingBuffer.create(ProducerType.MULTI, 
						new EventFactory<Order>() {  
				            @Override  
				            public Order newInstance() {  
				                return new Order();  
				            }  
				        }, 
				        1024 * 1024, 
						new YieldingWaitStrategy());
		
		SequenceBarrier barriers = ringBuffer.newBarrier();
		
		Consumer[] consumers = new Consumer[3];
		for(int i = 0; i < consumers.length; i++){
			consumers[i] = new Consumer("c" + i);
		}
		
		WorkerPool<Order> workerPool = 
				new WorkerPool<Order>(ringBuffer, 
						barriers, 
						new IntEventExceptionHandler(),
						consumers);
		
        ringBuffer.addGatingSequences(workerPool.getWorkerSequences());  
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*2);
        workerPool.start(newFixedThreadPool);  
        
        final CountDownLatch latch = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {  
        	final Producer p = new Producer(ringBuffer);
        	newFixedThreadPool.submit(new Runnable() {
				@Override
				public void run() {
					try {
						latch.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					for(int j = 0; j < 10; j ++){
						p.onData(Integer.toString(j));
					}
				}
			});
        } 
        Thread.sleep(2000);
        System.out.println("---------------开始生产-----------------");
        latch.countDown();
        Thread.sleep(5000);
        System.out.println("总数:" + consumers[0].getNum() );
        System.out.println("总数:" + consumers[1].getNum() );
        System.out.println("总数:" + consumers[2].getNum() );
	}
	
	static class IntEventExceptionHandler implements ExceptionHandler<Order> {  
	    public void handleEventException(Throwable ex, long sequence, Order event) {
	    	System.out.println("baocullalalall===============");
	    }  
	    public void handleOnStartException(Throwable ex) {}  
	    public void handleOnShutdownException(Throwable ex) {}  
	} 
}
