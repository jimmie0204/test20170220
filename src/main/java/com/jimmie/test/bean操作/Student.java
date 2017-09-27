package com.jimmie.test.bean操作;

import java.io.Serializable;

public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4152167547705485481L;

	public int age;
	
	public String name;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student(int age,String name){
		this.age = age;
		this.name = name;
	}
	
	public Student() {
		
	}
	
	@Override
	public String toString(){
		return age+":"+name+"---hashcode："+hashCode();
		
	}
}
