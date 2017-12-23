package com.jimmie.java.基本测试.all.common.classloader.热部署;

public class Hot {

	public void hot() {

		System.out.println(" version 1 : " + this.getClass().getClassLoader());

	}

}