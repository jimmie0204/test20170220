package com.jimmie.java.基本测试;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MapTest {

	static void print(Map<String, Object> map){
		for(Entry<String, Object> e:map.entrySet()){
			System.out.println(e.getKey()+"=="+e.getValue());
		}
		System.out.println("=======over=======");
	}

	
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map2 = new LinkedHashMap<String, Object>();
		Map<String, Object> map3 = new TreeMap<String, Object>();
		
		map.put("b", 2);
		map.put("d", 10);
		map.put("a", 1);
		map.put("c", 5);
		
		map2.put("b", 2);
		map2.put("d", 10);
		map2.put("a", 1);
		map2.put("c", 5);
		
		map3.put("b", 2);
		map3.put("d", 10);
		map3.put("a", 1);
		map3.put("c", 5);
		
		print(map);
		print(map2);
		print(map3);
		
	}
}
