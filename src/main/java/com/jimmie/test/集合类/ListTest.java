package com.jimmie.test.集合类;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

public class ListTest {

	
	@Test
	public void test1(){
		 List<Person> list = new ArrayList<Person>();
		 
		 Person p1 = new Person("n1",12,"boy");
		 Person p2 = new Person("n2",100,"boy");
		 Person p3 = new Person("n3",25,"girl");
		 
		 list.add(p1);
		 list.add(p2);
		 list.add(p3);
		 
		 
		 for(Person temp:list){
			 temp.setAge(temp.getAge()+10000);
		 }
		 
		 for(Person temp:list){
			 System.out.println(temp.toString());;
		 }
		List<Person> list2 = null;

		for(Person temp:list2){//空指针异常
			System.out.println(temp);
		}

	}
	
	@Test
	public void test2(){
		List<Car> list = new ArrayList<Car>(3);
		System.out.println("over!");
	}
	
	@Test
	public void test3(){
		List<String> list = new ArrayList<String>();
		list.add(null);
		list.add(null);
		list.add(null);
		list.add(null);
		System.out.println(list.size());
	}

	@Test
	public void test4(){
		List<Car> list = Lists.newArrayList();
		Car temp = null;
		for(int i=0;i<4;i++){
			temp = new Car();
			temp.setName(i);
			list.add(temp);
		}
				
		System.out.println(list.size());
		System.out.println(list.get(0).getName());
		System.out.println(list.get(2).getName());
		System.out.println(list.get(3).getName());
	}
}
