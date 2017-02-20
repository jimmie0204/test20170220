package com.jimmie.test.string;

import org.junit.Test;

public class StringTest {

	@Test
	public void test(){
		String ACCESS_TOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=%s&corpsecret=%s";
		String url = String.format(ACCESS_TOKEN_URL, "ssssss","bbbbb");
		System.out.println(url);
	}
}
