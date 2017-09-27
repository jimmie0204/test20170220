package com.jimmie.test.数字;

import java.util.concurrent.atomic.AtomicLong;

import org.junit.Test;

public class AutoTest {

	@Test
	public void test1(){
	    AtomicLong mi = new AtomicLong();
	    for(int i=0;i<1000;i++){
	    	System.out.println("i===="+(int) (mi.incrementAndGet()%60));
	    }
	}
	
	@Test
	public void test2(){
	    AtomicLong mi = new AtomicLong(99999);
	    for(int i=0;i<1000;i++){
	    	System.out.println("i===="+(int) (mi.incrementAndGet()%60));
	    }
	}
	
	@Test
	public void test3(){
		long result = 1;
	    for(int i=1;i<=10;i++){
	    	result*=i;
	    }
	    System.out.println("result===="+result);
	}
}
