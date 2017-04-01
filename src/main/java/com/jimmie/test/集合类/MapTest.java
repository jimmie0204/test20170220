package com.jimmie.test.集合类;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.Maps;
import com.jimmie.test.bean操作.Student;

public class MapTest {

	@Test
	public void test(){
		
		List<Student> vec = new ArrayList<Student>();
		Student stu1 = new Student(1,"name1");
		Student stu2 = new Student(2,"name2");
		Student stu3 = new Student(3,"name3");
		Student stu4 = new Student(4,"name4");
		vec.add(stu1);
		vec.add(stu2);
		vec.add(stu3);
		vec.add(stu4);
		
		Map<Integer, Student> map = new HashMap<Integer, Student>();
		
		for(Student temp:vec){
			
			if(map.get(temp.getAge())==null){
				System.out.println(temp);
				map.put(temp.getAge(), temp);
			}
		}
		
/*		System.out.println(map.get(0).getName());
		System.out.println(map.get(1).getName());
		System.out.println(map.get(2).getName());
		System.out.println(map.get(3).getName());*/
	}
	
	@Test
	public void test2(){
		List<Student> vec = new ArrayList<Student>();
		Student stu1 = new Student(1,"name1");
		Student stu2 = new Student(2,"name2");
		Student stu3 = new Student(3,"name3");
		Student stu4 = new Student(4,"name4");
		vec.add(stu1);
		vec.add(stu2);
		vec.add(stu3);
		vec.add(stu4);
		
		Map<Integer, Student> map = new HashMap<Integer, Student>();
		
		for(Student temp:vec){
			
			if(map.get(temp.getAge())==null){
				System.out.println("map1:"+temp);
				map.put(temp.getAge(), temp);
			}
		}
		
		List<Student> vec2 = new ArrayList<Student>();
		Student stu5 = new Student(1,"name9");
		Student stu6 = new Student(7,"name6");
		Student stu7 = new Student(3,"name7");
		Student stu8 = new Student(5,"name8");
		vec2.add(stu5);
		vec2.add(stu6);
		vec2.add(stu7);
		vec2.add(stu8);
		
		Map<Integer, Student> map2 = new HashMap<Integer, Student>();
		
		for(Student temp:vec2){
			
			if(map2.get(temp.getAge())==null){
				System.out.println("map2:"+temp);
				map2.put(temp.getAge(), temp);
			}
		}
		
		
		//sum
		
		for(Map.Entry<Integer, Student> temp:map.entrySet()){
			Integer key = temp.getKey();
			Student value = temp.getValue();
			
			Student s = map2.get(key);
			if(s!=null){
				value.setName(value.getName()+"--"+s.getName());
				map2.remove(key);
			}
		}
		
		System.out.println("map2剩余元素："+map2.size());
		map.putAll(map2);
		System.out.println(map);
		
	}
	
	@Test
	public void test3(){
		Map<Integer,String> supplierMap = Maps.newHashMap();
		String tt = "1";
		supplierMap.put(1, "a");
		supplierMap.put(2, "a");
		System.out.println(supplierMap);
		System.out.println(supplierMap.get(tt));
	}
	
}
