package com.jimmie.test.fastjson.test1;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class TestMain {

	public static void main(String[] args) {
		Grade grade = new Grade();
		grade.setName("wunainji");
		grade.setCount(2);
		
		Student s1 = new Student(1,"a");
		Student s2 = new Student(1,"b");
		
		List<Student> list = new ArrayList<Student>();
		list.add(s1);
		list.add(s2);
		
		grade.setSlist(list);

		System.out.println(JSONObject.toJSONString(grade));
	}
	
	@Test
	public void test2(){
		Grade2 grade = new Grade2();
		grade.setName("wunainji");
		grade.setCount(2);
		
		Student s1 = new Student(1,"a");
		Student s2 = new Student(1,"b");
		
		List<Student> list = new ArrayList<Student>();
		list.add(s1);
		list.add(s2);
		
		grade.setSlist(list);

		System.out.println(JSONObject.toJSONString(grade));
	}

	@Test
	public void test3(){//默认null字段不序列化
		Grade3 grade = new Grade3();
		grade.setName(null);
//		grade.setCount(null);
		
		Student s1 = new Student(1,"a");
		Student s2 = new Student(1,"b");
		
		List<Student> list = new ArrayList<Student>();
		list.add(s1);
		list.add(s2);
		
		grade.setSlist(list);

		System.out.println(JSONObject.toJSONString(grade));
	}
	
	@Test
	public void test4(){//加上WriteMapNullValue，null字段也序列化，为null
		Grade3 grade = new Grade3();
		grade.setName(null);
		grade.setCount(0);
		
		Student s1 = new Student(1,"a");
		Student s2 = new Student(1,"b");
		
		List<Student> list = new ArrayList<Student>();
		list.add(s1);
		list.add(s2);
		
		grade.setSlist(list);

		System.out.println(JSONObject.toJSONString(grade,SerializerFeature.WriteMapNullValue));
	}
}