package com.jimmie.java.基本测试.异常;

public class Test {

	public int  method() throws RuntimeException{
		int i = 1/0;
		System.out.println("我在异常之后输出");
		return 1;
	}
	public static void main(String[] args) {
		int result = new Test().method();
		if(result==1)
			System.out.println(result);

	}

}
