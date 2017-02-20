package com.jimmie.test.位运算;

import org.junit.Test;

public class WeiTest {

	@Test
	public void test1(){
		int i=3;
		System.out.println(3>>1);
	}
	
	@Test
	public void test2(){
		int base=3;
		
		for(int i=0;i<10;i++){
			System.out.println(i&base);
		}
	}
	
}
