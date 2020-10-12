package com.jimmie.test.fastjson.test1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
	public void test1(){
		Student s1 = new Student(1,"a");
		System.out.println(JSONObject.toJSONString(s1));
		Student3 s3 = JSON.parseObject(JSONObject.toJSONString(s1), Student3.class);
		System.out.println(s3.getAge());
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
		
		String jsonString = JSONObject.toJSONString(grade);
		
		System.out.println(jsonString);
		
		Grade4 parseObject = JSONObject.parseObject(jsonString,Grade4.class);
		System.out.println(parseObject.getGradeTime());
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
	
	//数组
	@Test
	public void test8(){
		GradeArray tt  = new GradeArray();
		tt.setCount(2);
		tt.setName("sdsd");
		tt.setStudentId(new Long[]{1L,45L});
		List<Integer> ages = new ArrayList<>();
		ages.add(23);
		ages.add(33);
		tt.setAges(ages);
		System.out.println(JSONObject.toJSONString(tt));
		
	}

	//null 格式化
	@Test
	public void test9(){
		Grade4 gt = new Grade4();
		gt.setCount(1);
		gt.setName("sdsd");
		gt.setGradeTime(null);
		gt.setStudent(null);

		System.out.println(JSONObject.toJSONString(gt));
	}


	//数组和对象,简单类型判定
	@Test
	public void test10(){
		Grade3 gt = new Grade3();
		gt.setCount(1);
		gt.setName("sdsd");
		Student s1 = new Student(1,"a");
		Student s2 = new Student(1,"b");
		List<Student> list = new ArrayList<Student>();
		list.add(s1);list.add(s2);
		gt.setSlist(list);

		Student2 k2 = new Student2(1,"b");
		gt.setStudent2(k2);

		String s = JSONObject.toJSONString(gt);
		System.out.println(s);

		JSONObject jsonObject = JSON.parseObject(s);
		System.out.println(jsonObject);

		Object slist = jsonObject.get("slist");
		Object student2 = jsonObject.get("student2");
		Object name_grade = jsonObject.get("name_grade");

		System.out.println(slist.getClass().getTypeName());
		System.out.println(student2.getClass().getTypeName());
		System.out.println(name_grade.getClass().getTypeName());

		if(slist instanceof JSONObject){
			System.out.println("slist JSONObject ");
		}else if(slist instanceof JSONArray){
			System.out.println("slist JSONArray ");
		}

		List<Student> t1 = JSON.parseArray(((JSONArray)slist).toJSONString(),Student.class);
		System.out.println(t1.getClass().getTypeName());

		if(student2 instanceof JSONObject){

			System.out.println("student2 JSONObject ");
		}else if(slist instanceof JSONArray){
			System.out.println("student2 JSONArray ");
		}

		Student2 t2 = JSON.parseObject(((JSONObject)student2).toJSONString(),Student2.class);
		System.out.println(t2.getClass().getTypeName());
		System.out.println(Student2.class.getGenericSuperclass());


		Object t3;
		if(name_grade instanceof JSONObject){

			System.out.println("name_grade JSONObject ");
		}else if(name_grade instanceof JSONArray){
			System.out.println("name_grade JSONArray ");
		}else{
			System.out.println("name_grade nothing");
		}
		t3 = (String)name_grade;

	}


	//TypeReference

	/**
	 * new TypeReference<Student2>(){}匿名内部类，
	 * 所以Type superClass = getClass().getGenericSuperclass();获取的就是TypeReference本身
	 */

	@Test
	public void test11(){

		System.out.println(new TypeReference<Student2>(){}.getType());//匿名内部类
		System.out.println(new TypeReference<Student2>(){}.getClass());
		System.out.println(new TypeReference<List<Student2>>(){}.getType());
		System.out.println(new TypeReference<List<Student2>>(){}.getClass());


	}

	@Test
	public void test12(){

		System.out.println(GenericsUtils.getSuperClassGenricType(Student2.class, 0));
		System.out.println(GenericsUtils.getSuperClassGenricType(Student2.class, 0));
		System.out.println(new TypeReference<List<Student2>>(){}.getType().getTypeName());
	}

	@Test
	public void test13(){
		Grade3 gt = new Grade3();
		gt.setCount(1);
		gt.setName("sdsd");
		Student s1 = new Student(1,"a");
		Student s2 = new Student(1,"b");
		List<Student> list = new ArrayList<Student>();
		list.add(s1);list.add(s2);
		gt.setSlist(list);

		Student2 k2 = new Student2(1,"b");
		gt.setStudent2(k2);

		String s = JSONObject.toJSONString(gt);
		System.out.println(s);

		JSONObject jsonObject = JSON.parseObject(s);

		Object slist = jsonObject.get("slist");

		Type type = new TypeReference<List<Student>>() {
		}.getType();

		Object t = JSONArray.parseObject(((JSONArray)slist).toJSONString(),type);

		System.out.println("success============");
	}


	@Test
	public void test14(){
		Class superClassGenricType = GenericsUtils.getSuperClassGenricType(new ArrayList<Student>() {
		}.getClass());
		System.out.println(superClassGenricType);

		System.out.println(new ArrayList<Student>(){}.getClass());
	}
}
