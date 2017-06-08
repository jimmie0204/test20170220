package com.jimmie.test.队列disruptor.mytest;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.ExceptionHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

public class OrderMain {

	public static ConcurrentLinkedQueue<Order> list = new ConcurrentLinkedQueue<Order>();
	
	public final static  int BUFFER_SIZE=32;  
	
	static class JimmieExceptionHandler  implements ExceptionHandler<Order>{

		@Override
		public void handleEventException(Throwable ex, long sequence, Order event) {
			System.out.println("订单"+event.getOrderNo()+"在位置【"+sequence+"】上处理时报错，错误信息:"+ex.getMessage());
		}

		@Override
		public void handleOnStartException(Throwable ex) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void handleOnShutdownException(Throwable ex) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		ExecutorService workeThreadrPool = Executors.newFixedThreadPool(10);
		
/*		@SuppressWarnings("deprecation")
		Disruptor<Order> disruptor = new Disruptor<>(new EventFactory<Order>() {

			@Override
			public Order newInstance() {
				return new Order();
			}
		}, BUFFER_SIZE, workeThreadrPool, ProducerType.SINGLE, new YieldingWaitStrategy());*/
		
		Disruptor<Order> disruptor = new Disruptor<>(new EventFactory<Order>() {

			@Override
			public Order newInstance() {
				return new Order();
			}
		}, BUFFER_SIZE, Executors.defaultThreadFactory(), ProducerType.SINGLE, new YieldingWaitStrategy());
		
		
		disruptor.setDefaultExceptionHandler(new JimmieExceptionHandler());
		
		//因为第二组handler会依赖第一组的处理，如果第一组某一个squence卡主，回导致第二组没法处理，这种情况应该用两个ringbuffer去处理
		disruptor.handleEventsWithWorkerPool(new TmsHandler(),new TmsHandler2()).handleEventsWithWorkerPool(new WmsHandler(),new WmsHandler2());
		
		disruptor.start();
		
		
		RingBuffer<Order> ringBuffer = disruptor.getRingBuffer();
		OrderFromAsProducer producer = new OrderFromAsProducer(ringBuffer);
		
		for(int i=0;i<10;i++){//从as来了十个单子
			producer.publish();
		}


		disruptor.shutdown();//关闭 disruptor，方法会堵塞，直至所有的事件都得到处理；
		workeThreadrPool.shutdown();//关闭 disruptor 使用的线程池；如果需要的话，必须手动关闭， disruptor 在 shutdown 时不会自动关闭；
	}
}
