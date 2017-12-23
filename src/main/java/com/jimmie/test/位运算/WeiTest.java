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
	
	@Test
	public void test3(){
		System.out.println(1<<29);
	}
	
	@Test
	public void test4(){
		Integer i =10;
		System.out.println(i.byteValue());
	}
	
	@Test
	public void test5(){
		System.out.println( -1L ^ (-1L << 5));
	}
	
	@Test
	public void test5_1(){
		System.out.println( Long.toBinaryString(-1L));//-1L
		System.out.println( Long.toBinaryString(1L));//1L
		System.out.println( Long.toBinaryString(-1L << 5));//-32L
		System.out.println( Long.toBinaryString(1L << 5));//32L
		System.out.println( Long.toBinaryString( -1L ^ (-1L << 5)));//32L
		System.out.println("==============================");
		System.out.println( Integer.toBinaryString(-1));//-1//11111111111111111111111111111111
		System.out.println( Integer.toBinaryString(1));//1
		System.out.println( Integer.toBinaryString(-1 << 5));//-32//11111111111111111111111111100000
		System.out.println( Integer.toBinaryString(1 << 5));//32
		
	}
	
	@Test
	public void test5_2(){
		System.out.println( Integer.toBinaryString(63));//1
		System.out.println( Integer.toBinaryString(32));//1
		System.out.println( Integer.toBinaryString(63^32));//1
	}
	
	@Test
	public void test6(){
		Long i = -1L;
		System.out.println(Long.toBinaryString( -1L ^ (-1L << 5)));
		System.out.println(Long.toBinaryString(i).length());
	}
	
	@Test
	public void test7(){
		int a=3,b=4;
		int c=a^a;
		a=a^b;
		b=b^a;
		a=a^b;
		System.out.println("a="+a+",b="+b);
	}
	
}
