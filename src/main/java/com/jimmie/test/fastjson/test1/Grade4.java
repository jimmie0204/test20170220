package com.jimmie.test.fastjson.test1;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class Grade4 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4984124242998617352L;

	@JSONField(name="name_grade",serialzeFeatures=SerializerFeature.WriteMapNullValue)
	private String name;
	
	@JSONField(name="st_count",serialzeFeatures={SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullNumberAsZero})
	private Integer count;

	@JSONField
	private List<Student> slist;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<Student> getSlist() {
		return slist;
	}

	public void setSlist(List<Student> slist) {
		this.slist = slist;
	}
}
