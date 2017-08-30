package com.jimmie.test.线程.AQS;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
	public static void main(String[] args) throws Exception{
		CountDownLatch s = new CountDownLatch(0);
		System.out.println(s.getCount());
		 s.countDown();
		 s.await();
		 System.out.println(s.getCount());
	}

	
}
