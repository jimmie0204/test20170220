package com.jimmie.java.基本测试.类测试2;

public class TestLL {

	public static TestLL ll = new TestLL();
	public static int a;
	public static int b=0;
	
	static{
		System.out.println("LL");
	}
	private TestLL(){
		a++;
		b++;
	}
	
	public static TestLL getTestLL(){
		return null;
	}
	
}
