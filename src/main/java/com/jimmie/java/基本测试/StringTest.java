package com.jimmie.java.基本测试;

import org.junit.Test;

import com.jimmie.test.bean操作.Student;

public class StringTest {

	
	@Test
	public void test1(){
		String c="ddd";
		func(c);
		System.out.println(c);
	}

	private static void func(String c) {
		c="rr";
		
	}
	
	@Test
	public void splittest(){
		String tt = "23|34";
		String yy = "45|45";
		
		System.out.println(tt.split("\\|").length);
		System.out.println(yy.split("\\|").length);
	}
	
	@Test
	public void test4(){
		String tt = "1111";
		String yy = "1111";
		
		System.out.println(tt==yy);
	}
	
	@Test
	public void test5(){
		System.out.println(Math.min(2.10, -0.90));
	}
	
	private void swap(String str){
		str="sdsd";
	}
	@Test
	public void test6(){
		String str = "we";
		swap(str);
		System.out.println(str);
	}
	
	
	@Test
	public void test7(){
		String str = new String("we");
		swap(str);
		System.out.println(str);
	}
	
	@Test
	public void test8(){
		StringBuilder str = new StringBuilder("ab");
		swap(str);
		System.out.println(str);
	}

	private void swap(StringBuilder str) {
		str = str.delete(0, 2).append("xxxx");
	}
	
	@Test
	public void test9(){
		String a = new String("111");  
		String b = a;  
		a = "222";  
		System.out.println(b);//结果是111  
		System.out.println(b.equals(a));//false  
	}
	
	@Test
	public void test10(){
		Student s = new Student();
		Student t = s;
		s = new Student();
		System.out.println(s);
		System.out.println(t);
	}
	
	@Test
	public void test11(){
		Student s = new Student();
		System.out.println(s);
		swap(s);
		System.out.println(s);
	}

	private void swap(Student s) {
		s = new Student(); 
	}
	
	@Test
	public void test12(){
	
		int i=0; //-----0
		if(i==0){ //----1
			i=1; //-----2
			System.out.println(i);
		}
	}
	
}
