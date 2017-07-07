package com.jimmie.java.基本测试.类测试;

public class C5 extends C2{

	public void fc5(){
		
	}
	public static void main(String[] args) {
		C2 c2 = new C2();
		C5 c5 = (C5)c2;
//		C5.class.cast(c2);
//		System.out.println(C5.class.cast(c2));
	}
}
