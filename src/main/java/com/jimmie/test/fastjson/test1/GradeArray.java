package com.jimmie.test.fastjson.test1;

import java.io.Serializable;
import java.util.List;


public class GradeArray implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4984124242998617352L;

	private String name;
	
	private int count;
	
	private Long[] studentId;
	
	private List<Integer> ages;

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

	public Long[] getStudentId() {
		return studentId;
	}

	public void setStudentId(Long[] studentId) {
		this.studentId = studentId;
	}

	public List<Integer> getAges() {
		return ages;
	}

	public void setAges(List<Integer> ages) {
		this.ages = ages;
	}
}
