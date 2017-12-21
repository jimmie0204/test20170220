package com.jimmie.java.基本测试.clone;

public class Test1 {

	public static void main(String[] args) {
		A a1=new A();  
		A a2=new A();  
		a1.name="a1";  
		a2=(A) a1.clone();  
//		a2.name="a2";  
		System.out.println("a1.name="+a1.name);  
		System.out.println("a2.name="+a2.name);
	}
}
