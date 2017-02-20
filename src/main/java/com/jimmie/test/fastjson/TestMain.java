package com.jimmie.test.fastjson;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
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
	
}
