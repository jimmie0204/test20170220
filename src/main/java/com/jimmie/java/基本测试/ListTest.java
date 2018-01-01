package com.jimmie.java.基本测试;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.Test;


public class ListTest {

	@Test
	public void test(){
	    List<String> names = new ArrayList<String>();
        names.add("first");
        names.add("second");
        names.add("third");
        names.add("fourth");
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            if (it.next().equals("first")) {
            	it.remove();//这样移除不会报错
            }
        }
        System.out.println(names.size()); 
        System.out.println(names.get(0));
	}
	
	@Test
	public void test2(){//只能移除倒数第二个？
		List<String> names = new ArrayList<String>();  
		names.add("first");  
		names.add("second");  
		names.add("third");  
		names.add("third2"); 
		names.add("third3"); 
		Iterator<String> it = names.iterator();  
		while (it.hasNext()) {  
		    if (it.next().equals("third2")) {  
		    	names.remove("third2");  //错误的移除方式
		    }  
		} 
	}
	
	@Test
	public void test3(){
		final List<String> names = new CopyOnWriteArrayList<String>();
        names.add("1");
        names.add("2");
        names.add("3");
        names.add("4");
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            if (it.next().equals("1")) {
                names.remove("1");
            }
 
        }
        System.out.println(names.size());
	}
	
	@Test
	public void test4(){
		List<Student> vec = new ArrayList<Student>();
		Student stu1 = new Student(1,"name1");
		Student stu2 = new Student(2,"name2");
		Student stu3 = new Student(3,"name3");
		Student stu4 = new Student(4,"name4");
		vec.add(stu1);
		vec.add(stu2);
		vec.add(stu3);
		vec.add(stu4);
		
		for(Student temp:vec){
			if(temp.getName().equalsIgnoreCase("name1"))
				temp.setName("jimmie");//可以重新设置属性
			
			if(temp.getName().equalsIgnoreCase("name2")){
//				vec.remove(temp);//错误
			}

		}
		
		System.out.println(vec.get(0).getName());
		System.out.println(stu1.hashCode());
	}
	
	@Test
	public void test5(){
		List<Student> vec = new ArrayList<Student>();
		Student stu1 = new Student(1,"name1");
		Student stu2 = new Student(2,"name2");
		Student stu3 = new Student(3,"name3");
		Student stu4 = new Student(4,"name4");
		vec.add(stu1);
		vec.add(stu2);
		vec.add(stu3);
		vec.add(stu4);
		
		List<Student> vec2 = null;
		List<Student> vecAll = new ArrayList<Student>();
		vecAll.addAll(vec);
		vecAll.addAll(vec2);//报错，空指针
		System.out.println(vecAll);
	}

}
