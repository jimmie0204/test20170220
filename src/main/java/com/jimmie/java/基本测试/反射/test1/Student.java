package com.jimmie.java.基本测试.反射.test1;

public class Student {

	
	 private boolean is;

	 private String name;

	 protected Integer age;

	public Student() {
	}

	public Student(boolean is, String name, Integer age) {
		this.is = is;
		this.name = name;
		this.age = age;
	}

	public boolean isIs() {
		return is;
	}

	public void setIs(boolean is) {
		this.is = is;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
