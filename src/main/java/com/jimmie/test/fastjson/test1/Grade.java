package com.jimmie.test.fastjson.test1;

import java.io.Serializable;
import java.util.List;


public class Grade implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4984124242998617352L;

	private String name;
	
	private int count;
	
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
