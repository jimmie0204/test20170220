package com.jimmie.test.对象池;

import java.util.concurrent.atomic.AtomicInteger;

public class Zeus {

	private String name;
	
	private Integer age;
	
	public static AtomicInteger count = new AtomicInteger(0);
	
	public Zeus(){
		System.out.println("创建第"+count.incrementAndGet()+"个Zeus对象====");
		setName("zues"+count);
		setAge(count.get());
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
