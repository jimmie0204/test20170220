package com.jimmie.test.fastjson.test1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

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
//		grade.setCount(0);
		
		Student s1 = new Student(1,"a");
		Student s2 = new Student(1,"b");
		
		List<Student> list = new ArrayList<Student>();
		list.add(s1);
		list.add(s2);
		
		grade.setSlist(list);

		System.out.println(JSONObject.toJSONString(grade,SerializerFeature.WriteMapNullValue));
	}
	
	@Test
	public void test5(){//默认null字段不序列化,现在加了注解，可以输出null了
		Grade4 grade = new Grade4();
		grade.setName(null);
//		grade.setCount(null);
		grade.setGradeTime(new Date());
		Student2 s1 = new Student2(1,"a");
		Student2 s2 = new Student2(1,"b");
		
		List<Student2> list = new ArrayList<Student2>();
		list.add(s1);
		list.add(s2);
		grade.setSlist(list);

		Student s = new Student(100,"student");
		grade.setStudent(s);
		
		System.out.println(JSONObject.toJSONString(grade));
	}
	
	//值引用问题（重复引用）
	@Test
	public void test6(){
		Student2 ss = new Student2();
//		List<Student2> sList = Lists.newArrayList();
		Map<String, Student2> map = Maps.newHashMap();
		map.put("1", ss);
		map.put("2", ss);
		System.out.println(JSONObject.toJSONString(map,SerializerFeature.DisableCircularReferenceDetect));
	}
	
	//值引用问题（循环引用）
	@Test
	public void test7(){
		Map<String, Object> map = Maps.newHashMap();
		Map<String, Object> map2 = Maps.newHashMap();
		map.put("1", map2);
		map.put("2", map);
//		System.out.println(JSONObject.toJSONString(map));
		System.out.println(JSONObject.toJSONString(map,SerializerFeature.DisableCircularReferenceDetect));
	}
	
	
}
