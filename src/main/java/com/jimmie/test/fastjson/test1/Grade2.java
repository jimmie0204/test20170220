package com.jimmie.test.fastjson.test1;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class Grade2 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4984124242998617352L;

	@JSONField(name="name_grade")
	private String name;
	
	@JSONField
	private int count;
	
	@JSONField
	private List<Student> slist;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Student> getSlist() {
		return slist;
	}

	public void setSlist(List<Student> slist) {
		this.slist = slist;
	}
}
