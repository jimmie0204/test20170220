package com.jimmie.java.基本测试.类加载.静态加载;

public class StaticTest {

	public static void main(String[] args) {
//		new B();
		Child child = new Child();
//		System.out.println(Child.count);
		System.out.println(child.num);

	}
}
