package com.jimmie.java.基本测试.异常;


public class ExceptionTest {

	public void fun1(){
		throw new IllegalArgumentException("参数错误");
	}
	
	public void fun2(){
/*		try {
			fun1();
		} catch (Exception e) {
			System.out.println("catch a 异常。。");
//			return ;
		}*/
		fun1();
		System.out.println("我在cath之后。。。。输出");
	}
	public static void main(String[] args) {
		new ExceptionTest().fun2();
	}

}
