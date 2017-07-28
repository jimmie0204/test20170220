package com.jimmie.java.基本测试;

public class ExceptionTest {

	public static void main(String[] args) {
		try {
			int i=1/0;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("zhenima 输出出来了");
		}finally {
			System.out.println("我在final里。。。");
		}
	}
}
