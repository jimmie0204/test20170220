package com.jimmie.test.fastjson.test1;

import java.io.Serializable;

public class Student3 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4152167547705485481L;

	public String age;
	
	public String name;
	
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student3(String age,String name){
		this.age = age;
		this.name = name;
	}
	
	public Student3() {
		
	}
	
	@Override
	public String toString(){
		return age+":"+name;
		
	}
}
