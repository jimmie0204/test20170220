package com.jimmie.test.并发;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	public static void main(String[] args) {
		Semaphore s = new Semaphore(0);
		System.out.println(s.availablePermits());
		 s.release();
		 System.out.println(s.availablePermits());
	}

	
}
