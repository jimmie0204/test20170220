package com.jimmie.test.数字;

import java.math.BigDecimal;

import org.junit.Test;

public class BigDecimalTest {

	@Test
	public  void test1(){
		BigDecimal l = new BigDecimal(0.01);
		
		System.out.println(l.intValue());;
	}
	
	@Test
	public void test2(){
		BigDecimal.ONE.add(null);
	}
	
	@Test
	public void test3(){
		BigDecimal.ONE.multiply(null);
	}
	
	@Test
	public void test4(){
		BigDecimal aa = null;
		aa.multiply(BigDecimal.ONE);
	}
	
	@Test
	public void test5(){
		Integer i = null;
		new BigDecimal(i);
	}
	
	@Test
	public void test6(){
		System.out.println(BigDecimal.ONE.add(new BigDecimal(-100)));;
	}
	
	@Test
	public void test7(){
		int i=0;
		BigDecimal big = new BigDecimal(0.00);
		if(big.compareTo(BigDecimal.ZERO)==0)
			System.out.println("00000");
		else{
			System.out.println("chuyi");
			BigDecimal.ONE.divide(big,2,BigDecimal .ROUND_HALF_UP);
		}
	}
	
	@Test
	public void test8(){
		System.out.println(BigDecimal.ONE.compareTo(BigDecimal.ZERO));
	}
}
