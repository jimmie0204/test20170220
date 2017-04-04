package com.jimmie.test.虚拟机;

import org.junit.Test;

public class MemaryTest {

	@Test
	public void test(){
		SF[] sfArray = new SF[5];
		
		for(int i=1;i<5;i++){
			SF sf = sfArray[i];
			System.out.println(sf);
		}
	}
}
