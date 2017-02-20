package com.jimmie.test.原子操作;

import java.util.concurrent.atomic.AtomicLong;

import org.junit.Test;

public class AtomicTest {

    private static AtomicLong mi = new AtomicLong();
	@Test
	public void test(){

		for (int i = 0; i < 5; i++) {
			System.out.println(mi.incrementAndGet()%3);
		}

	}
}
