package com.jimmie.test.谷歌guava;

import com.google.common.collect.*;
import com.jimmie.test.bean操作.Student;
import org.junit.Test;

import java.util.ArrayList;

public class MapTest {

	@Test
	public void testmap(){
		Student s = new Student(100,"a100");
		Student s2 = new Student(200,"b200");

		Table<Integer, String, Student> table = HashBasedTable.create();
		table.put(1,"a",s);
		table.put(1,"a",s2);
		System.out.println("=====success=========="+table.get(1,"a").getName());

		System.out.println("=====success=========="+table.size());
	}


	
}
