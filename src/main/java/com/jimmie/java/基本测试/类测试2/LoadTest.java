package com.jimmie.java.基本测试.类测试2;

public class LoadTest extends AA{

	static {
		System.out.println("LoadTest static...");
	}
	
	public static void main(String[] args) {
		

		new LoadTest();
	}

}
