package com.jimmie.test.bean操作;

import net.sf.cglib.beans.BeanCopier;

import org.junit.Test;

public class BeanCopyTest {

	private static Object beancopy(Object source,Object target){
		BeanCopier bc = BeanCopier.create(source.getClass(),target.getClass(),false);
		bc.copy(source, target, null);
		return target;
	}
	@Test
	public void test1(){
		
		Student s1 = new Student(12, null);
		Student s2 = new Student();
		BeanCopier bc = BeanCopier.create(Student.class,Student.class,false);
		bc.copy(s1, s2,null);
		System.out.println(s2.getAge());
	}
	
	@Test
	public void test2(){
		
		Student s1 = new Student(12, null);
		Student s2 = new Student(23,"dd");//会覆盖
		beancopy(s1,s2);
		System.out.println(s2.getAge());
		System.out.println(s2.getName());
	}
}
