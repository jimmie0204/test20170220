package com.jimmie.test.桶;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.util.concurrent.RateLimiter;

public class RateLimiterTest {

	@Test
	public void test0() throws InterruptedException{
		RateLimiter limiter3 = RateLimiter.create(0.5);
		for(int i=0;i<5;i++){
			System.out.println(limiter3.acquire());
			Thread.sleep(2L);
		}
	}
	
	@Test
	public void test() throws InterruptedException{
		RateLimiter limiter = RateLimiter.create(5);//每秒五个，最大容量五个
		System.out.println(limiter.acquire(10));
		System.out.println(limiter.acquire());
		System.out.println(limiter.acquire());
		System.out.println(limiter.acquire());
		System.out.println(limiter.acquire());
		System.out.println(limiter.acquire());
		
		System.out.println("=================");
		
		RateLimiter limiter2 = RateLimiter.create(5);
		Thread.sleep(1000L);
		System.out.println(limiter2.acquire(10));
		System.out.println(limiter2.acquire());
		System.out.println(limiter2.acquire());
		System.out.println(limiter2.acquire());
		System.out.println(limiter2.acquire());
		System.out.println(limiter2.acquire());
		
		System.out.println("=================");
		
		RateLimiter limiter3 = RateLimiter.create(5);
		Thread.sleep(2000L);
		System.out.println(limiter3.acquire(10));
		System.out.println(limiter3.acquire());
		System.out.println(limiter3.acquire());
		System.out.println(limiter3.acquire());
		System.out.println(limiter3.acquire());
		System.out.println(limiter3.acquire());
	}
	
	@Test
	public void test2() throws InterruptedException{
		RateLimiter limiter = RateLimiter.create(5, 1000, TimeUnit.MILLISECONDS);
		for(int i = 1; i < 5;i++) {
		    System.out.println(limiter.acquire());
		}
		Thread.sleep(1000L);
		for(int i = 1; i < 5;i++) {
		    System.out.println(limiter.acquire());
		}
	}
}
