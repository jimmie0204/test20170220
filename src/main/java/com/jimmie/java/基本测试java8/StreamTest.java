package com.jimmie.java.基本测试java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.jimmie.java.基本测试.Student;

public class StreamTest {

	@Test
	public void test1(){
		List<Student> list = null;
		list.stream();
	}


	@Test
	public void test2(){
		List<String> al = Arrays.asList("a","b","c","d");

		Normal n = new Normal();
		al.forEach(Normal::printStatic);
		al.forEach(n::printNoStatic);


	}

	@Test
	public void test3(){

		List<Person> list = new ArrayList();
		list.add(new Person(1, "haha"));
		list.add(new Person(2, "rere"));
		list.add(new Person(3, "fefe"));



		Map<Integer, Person> mapp = list.stream().collect(Collectors.toMap(Person::getId, Function.identity()));

		System.out.println(mapp);

		System.out.println(mapp.get(1).getName());

		Map<Integer, String> map = list.stream().collect(Collectors.toMap(Person::getId, Person::getName));

		System.out.println(map);
	}

	@Test
	public void test4(){
		Map<String, Integer> reverseOrderMap = new HashMap();
		reverseOrderMap.put("10001",1);
		reverseOrderMap.put("10002",-1);
		reverseOrderMap.put("10003",100);
		reverseOrderMap.put("10004",0);
		reverseOrderMap.put("10005",18);

		Map<String, Integer> newCollect = reverseOrderMap.entrySet().stream().filter(entry -> entry.getValue() != 0)
				.collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
//		Stream<Map.Entry<String, Integer>> entryStream = reverseOrderMap.entrySet().stream().filter(entry -> entry.getValue() != 0);
//		Map<String, Integer> newCollect = entryStream.collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));

		System.out.println(reverseOrderMap);
		System.out.println(newCollect);
	}

}
