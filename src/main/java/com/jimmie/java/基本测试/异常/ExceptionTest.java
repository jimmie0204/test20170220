package com.jimmie.java.基本测试.异常;


import org.junit.Test;

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

	/**
	 * 打印异常所有变量
	 *BusinessException{message='sss
	 ', code=12}
	 at com.jimmie.java.基本测试.异常.ExceptionTest.test(ExceptionTest.java:28)
	 */
	@Test
	public void test(){
		BusinessException businessException = new BusinessException();
//		businessException.setMessage("sss");
		businessException.setCode(12);
		throw businessException;

	}

	/**
	 * 自带message变量
	 * hhh
	 BusinessException{code=12}
	 at com.jimmie.java.基本测试.异常.ExceptionTest.test2(ExceptionTest.java:43)
	 */
	@Test
	public void test2(){
		throw new BusinessException("hhh",12);

	}
}
