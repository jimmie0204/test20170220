package com.jimmie.java.基本测试java8.函数编程;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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

	@Test
	public void test5(){
		List<List<Person>> listAll = new ArrayList<>();
		Person p1 = new Person(1,"ab");
		Person p2 = new Person(2,"bd");
		Person p3 = new Person(3,"be");
		Person p4 = new Person(4,"wb");
		Person p5 = new Person(5,"sd");
		Person p6 = new Person(6,"cc");
		List<Person> list1 = new ArrayList<>();
		List<Person> list2 = new ArrayList<>();

		list1.add(p1);list1.add(p2);list1.add(p3);
		list2.add(p4);list2.add(p5);list2.add(p6);
		listAll.add(list1);
		listAll.add(list2);


		List<Person> result = listAll.stream().parallel().flatMap(t -> t.stream().filter(p -> p.getName().contains("b")))
				.collect(Collectors.toList());
		System.out.println(result);

		String b = listAll.stream().parallel().flatMap(t -> t.stream().filter(p -> p.getName().contains("b")))
				.map(p -> p.getName()).collect(Collectors.joining("-"));
		System.out.println(b);

	}

}
