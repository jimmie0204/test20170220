package com.jimmie.test.fastjson.test2;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

public class JTest {

	@Test
	public void test1(){
		ChannelAsDto2 tt  = new ChannelAsDto2();
		
		tt.setId(1988);
		tt.setName("fruit");
		tt.setChannaelType("quanugo");
		tt.setIsGroup(0);
		
		String strJson = JSONObject.toJSONString(tt);
		System.out.println(strJson);
		ChannelAsDto2 parseObject = JSONObject.parseObject(strJson, ChannelAsDto2.class);
		System.out.println(parseObject.getName());
	}
}
