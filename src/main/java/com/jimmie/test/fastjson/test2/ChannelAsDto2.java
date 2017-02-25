package com.jimmie.test.fastjson.test2;

import com.alibaba.fastjson.annotation.JSONField;

public class ChannelAsDto2 {

	private Integer id;
	
	@JSONField(name="nm_itn")
	private String name;
	
	@JSONField(name="ctg_typ")
	private String channaelType;
	
	@JSONField(name="grp_pch")
	private Integer isGroup;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChannaelType() {
		return channaelType;
	}

	public void setChannaelType(String channaelType) {
		this.channaelType = channaelType;
	}

	public Integer getIsGroup() {
		return isGroup;
	}

	public void setIsGroup(Integer isGroup) {
		this.isGroup = isGroup;
	}








}
