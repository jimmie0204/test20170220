package com.jimmie.test.fastjson.test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

public class TagTest2 {

	public static String print(InputStream i){
		StringBuffer sb = new StringBuffer();
		BufferedReader bf = null;
		String ch = null;
		try {
			bf = new BufferedReader(new InputStreamReader(i));
			while((ch=bf.readLine())!=null){
				sb.append(ch);
			}
		} catch (Exception e) {
			try {
				bf.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return sb.toString();
		
	}
	
	public static <T> List<T> jsonTranceTo(String data,Class<T> clazz){
		
		return JSONArray.parseArray(data, clazz);
		
	}
	
	public static <T> T  jsonTranceTo(String data,T arg){
		
		arg = (T) JSON.parseObject(data, arg.getClass());
		return 	arg;
		
	}
	
	public static void main(String[] args) {
		InputStream ll = TagTest2.class.getResourceAsStream("b.txt");
		if(ll==null)
			System.out.println("文件为空");
		String st = print(ll);
		System.out.println(st);
		
		
		Map<String, Object> map = JSONObject.parseObject(st, Map.class);
		String data = map.get("data").toString();
		System.out.println("data:"+data);
		List<ChannelAsDto2> list2 = JSONObject.parseArray(data, ChannelAsDto2.class);
		System.out.println(list2.get(0).getName());
		
		List<ChannelAsDto2> list4 = JSONArray.parseArray(data, ChannelAsDto2.class);
		System.out.println(list4.get(1).getChannaelType());
		
		List<ChannelAsDto2> jsonTranceTo = jsonTranceTo(data, ChannelAsDto2.class);
		System.out.println(jsonTranceTo.get(0).getName());
		List<String> nn = Lists.newArrayList();
		nn.add("asas");
		nn.add("hhj");
		nn.add("iiuu");
		String jsonss = JSON.toJSONString(nn);
		System.out.println(nn);
		List<JSONObject> list5 = JSONObject.parseObject(data,List.class);
		System.out.println(list5.get(0));
	}

}
