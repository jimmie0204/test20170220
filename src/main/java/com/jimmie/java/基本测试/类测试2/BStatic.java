package com.jimmie.java.基本测试.类测试2;

public class BStatic {

	private int cout = 1;

	private static int flag = 0;
	public static void main(String[] args) {

	}

	public class CC{
		public void fun(){
			System.out.println("1");
			System.out.println(cout);
			System.out.println(flag);
		}
	}
}
