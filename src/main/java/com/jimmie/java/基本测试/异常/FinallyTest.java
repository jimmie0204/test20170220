package com.jimmie.java.基本测试.异常;

public class FinallyTest {

	public static void main(String[] args) {

		try {
			try {
				throw new NullPointerException("null");
			}finally{
				System.out.println("inner finally.. ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			System.out.println("outer finally.. ");
		}

	}

}
