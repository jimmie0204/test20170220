package com.jimmie.test.对象池;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class ZeusPoolConfig extends GenericObjectPoolConfig{

	private int initNum;
			
	private long validTime;

	public Long getValidTime() {
		return validTime;
	}

	public void setValidTime(Long validTime) {
		this.validTime = validTime;
	}

	public Integer getInitNum() {
		return initNum;
	}

	public void setInitNum(Integer initNum) {
		this.initNum = initNum;
	}
	
	
}
