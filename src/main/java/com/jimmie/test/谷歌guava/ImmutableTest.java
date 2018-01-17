package com.jimmie.test.谷歌guava;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.jimmie.test.bean操作.Student;

public class ImmutableTest {

	@Test
	public void testList(){
		ArrayList<String> newArrayList = Lists.newArrayList();
		newArrayList.add("a");
		newArrayList.add("b");
		ImmutableList<String> copyOf = ImmutableList.copyOf(newArrayList);
		
//		copyOf.add("c");
//		copyOf.clear();
		newArrayList.clear();
		newArrayList = null;
		ImmutableList<String> copyOf2 = ImmutableList.copyOf(newArrayList);//不能为空
		System.out.println(copyOf2.size());
	}
	
	@Test
	public void testmap(){
		Student s = new Student();
		s.setName("sd");
		s.setAge(12);
		ImmutableMap<String, Student> map = ImmutableMap.of("s1", s);
		s.setAge(13);
		System.out.println("=====success=========="+map.get("s1").getAge());
		Map<String, List<Long>> map2 = ImmutableMap.of("s1", Lists.newArrayList());
		sss(map);

	}

	private void sss(Map<String, Student> map){

	}
	
}
