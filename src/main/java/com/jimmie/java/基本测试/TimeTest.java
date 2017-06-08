package com.jimmie.java.基本测试;

import org.junit.Test;

public class TimeTest {

	@Test
	public void test1(){
		System.out.println(System.currentTimeMillis());
		System.out.println(System.nanoTime());
	}
}
