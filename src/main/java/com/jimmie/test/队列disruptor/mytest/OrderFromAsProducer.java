package com.jimmie.test.队列disruptor.mytest;

import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.RingBuffer;

public class OrderFromAsProducer {
	
	private static Long num = 0l;
	
	private final RingBuffer<Order> ringbuff;
	
	public OrderFromAsProducer(RingBuffer<Order> ringbuff) {
		super();
		this.ringbuff = ringbuff;
	}

	private static final EventTranslator<Order> pulisher = new EventTranslator<Order>() {

		@Override
		public void translateTo(Order event, long sequence) {
			event.setOrderNo("order"+num);
			event.setMoney(num.intValue());
			event.setStatus((byte) 1);
			num++;
		}
	};
	
	public void publish(){
		ringbuff.publishEvent(pulisher);
	}
	
}
