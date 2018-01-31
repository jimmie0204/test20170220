package com.jimmie.test.fastjson;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jimmie.test.bean操作.Student;


public class TestMain {

	@Test
	public void test1(){
		List<Student> list = new ArrayList<Student>();
		list.add(new Student(11, "aa"));
		list.add(new Student(22, "bb"));
		String jsonArrayText = JSON.toJSONString(list);
		System.out.println(jsonArrayText);;
		List<Student> list2 = JSONArray.parseArray(jsonArrayText,Student.class);
		System.out.println(list2.get(0).getName());
	}
	
	@Test
	public void test2(){//Exception
		String ch = JSONArray.toJSONString(new Student(1, "fff"));
		System.out.println(ch);;
		List<Student> list2 = JSONArray.parseArray(ch,Student.class);
		System.out.println(list2.get(0).getName());
	}
	
	@Test
	public void test3(){
		List<String> list = new ArrayList<String>();
		list.add("aa");
		list.add("bb");
		String jsonArrayText = JSON.toJSONString(list);
		System.out.println(jsonArrayText);;
		List<String> list2 = JSONArray.parseArray(jsonArrayText,String.class);
		System.out.println(list2);
	}
	
	@Test
	public void test4(){
		Bear bear = new Bear();
		String jsonArrayText = JSON.toJSONString(bear);
		System.out.println(jsonArrayText);
		
		Bear parseObject = JSONObject.parseObject(jsonArrayText, Bear.class);
		System.out.println(parseObject.getT());
		System.out.println(parseObject.getT2());
	}
	
	static class Bear{
		private BigDecimal t  = new BigDecimal(12.1);
		private Double t2 = 12.23;

		public BigDecimal getT() {
			return t;
		}

		public void setT(BigDecimal t) {
			this.t = t;
		}

		public Double getT2() {
			return t2;
		}

		public void setT2(Double t2) {
			this.t2 = t2;
		}
		
	}
	
}
