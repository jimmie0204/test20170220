package com.jimmie.test.fastjson.test1;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

public class Student2 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4152167547705485481L;

	@JSONField(name="s_age")
	public int age;
	
	@JSONField(name="s_name")
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

	public Student2(int age,String name){
		this.age = age;
		this.name = name;
	}
	
	public Student2() {
		
	}
	
	@Override
	public String toString(){
		return age+":"+name;
		
	}
}
