package com.jimmie.java.基本测试;

import org.junit.Test;

import com.jimmie.test.bean操作.Student;

public class ArrayTest {

	@Test
	public void test1(){
		Student[] s = new Student[5];
		System.out.println(s.length);
	}
}
