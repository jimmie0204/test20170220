package com.jimmie.test.泛型;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

public class HttpUtils {

	private static Logger log = LoggerFactory.getLogger(HttpUtils.class);
	
	@SuppressWarnings("unchecked")
	public static <K,V,T> T getHttp(String ipKey,String uri,Map< K , V > params,T arg){
		String yy="[\"aa\",1,2]";
		arg = (T) JSON.parseObject(yy, arg.getClass());
//		arg = (T) JSON.parseArray(yy);
		return arg;
		
	}
	
	public static void main(String[] args) {
		List<String> sList = Lists.newArrayList();
		List<String> http = HttpUtils.getHttp("", "",null, sList);
		System.out.println(http);
		
		
//		
	}
}
