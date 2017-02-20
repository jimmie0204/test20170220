package com.jimmie.test.自定义jartest;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pie.jimmie.foo.App;


public class MyJarTest {

	Logger log = LoggerFactory.getLogger(MyJarTest.class);
	
	@Test
	public void test1(){
		log.info("test中的日志信息");
		App.print();
	}
}
