package com.jimmie.java.基本测试;

import org.junit.Test;

public class StringTest {

	
	@Test
	public void test1(){
		String c="ddd";
		func(c);
		System.out.println(c);
	}

	private static void func(String c) {
		c="rr";
		
	}
	
	@Test
	public void splittest(){
		String tt = "23|34";
		String yy = "45|45";
		
		System.out.println(tt.split("\\|").length);
		System.out.println(yy.split("\\|").length);
	}
	
	@Test
	public void test4(){
		String tt = "1111";
		String yy = "1111";
		
		System.out.println(tt==yy);
	}
	
	@Test
	public void test5(){
		System.out.println(Math.min(2.10, -0.90));
	}
}
