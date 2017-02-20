package com.jimmie.test.excel测试;

import java.io.File;

import org.junit.Test;

public class JunitTest {

	@Test
	public void test(){
		File file = new File("D:\\aaa.xls");
		
		System.out.println(file.length()/1024);
	}
}
