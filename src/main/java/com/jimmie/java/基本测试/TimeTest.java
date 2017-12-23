package com.jimmie.java.基本测试;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.utils.DateUtils;
import org.junit.Test;

import com.jimmie.test.随机数.DateUtil;

public class TimeTest {

	@Test
	public void test1(){
		System.out.println(System.currentTimeMillis());
		System.out.println(System.nanoTime());
	}
	
	@Test
	public void test2() throws InterruptedException, IOException{
		System.out.println(System.currentTimeMillis());
		System.out.println(System.nanoTime());
		
		Date time = DateUtil.str2Date("2017-11-29 16:00:00", DateUtil.Y_M_D_H_M_S);
		while(time.after(new Date())){
			System.out.println("我在2017-11-29 16:00:00之前============");
			TimeUnit.SECONDS.sleep(1);
		}
		
		System.out.println("我在2017-11-29 16:00:00之后了============over");
		
		System.in.read();
	}
}
