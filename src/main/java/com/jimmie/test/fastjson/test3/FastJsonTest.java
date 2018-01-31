package com.jimmie.test.fastjson.test3;

import java.math.BigDecimal;

import org.junit.Test;

public class FastJsonTest {

	@Test
	public void test(){
		NumberDemo num = new NumberDemo();
		num.setMoney(new BigDecimal(123.123));
	}
	
}
