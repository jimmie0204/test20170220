package com.jimmie.java.基本测试;

import java.util.concurrent.atomic.AtomicInteger;

public class FinalTest {

	public static final String token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	private static AtomicInteger num = new AtomicInteger(1);
	
	public static int add(int data){
		data++;
		System.out.println("====="+data);
		return data;
	}
	public static void main(String[] args) {
		token_url.replace("APPID", "wocao");
		System.out.println(token_url);
		System.out.println(token_url.replace("APPID", "wocao"));
		for(int i=0;i<10;i++){
			final int data = num.incrementAndGet();
			System.out.println(data);
		}

		final int data = 10;
		add(data);//可以自增
	}

}
