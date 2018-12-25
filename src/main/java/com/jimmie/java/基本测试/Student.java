package com.jimmie.java.基本测试;

import com.jimmie.test.随机数.DateUtil;

import java.util.Date;

public class Student {

	public int age;
	
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

	public String name;

	private Date birthDay;

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public Student(){}

	public Student(int age,String name){
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student{" +
				"age=" + age +
				", name='" + name + '\'' +
				", birthDay=" + DateUtil.getDate(birthDay) +
				'}';
	}
}
