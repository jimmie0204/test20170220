package com.jimmie.test.bean操作;

import javax.annotation.PostConstruct;

public class ContrustMaker {

	public ContrustMaker(){
		System.out.println("创建了一个ContrustMaker类====");
	}
	
	@PostConstruct
	public void intiBean(){
		System.out.println("执行了PostConstruct====");
	}
}
