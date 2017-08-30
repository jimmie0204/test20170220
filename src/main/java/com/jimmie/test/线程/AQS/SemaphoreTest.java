package com.jimmie.test.线程.AQS;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	public static void main(String[] args) {
		Semaphore s = new Semaphore(0);
		System.out.println(s.availablePermits());
		 s.release();
		 System.out.println(s.availablePermits());
	}

	
}
