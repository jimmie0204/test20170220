package com.jimmie.java.基本测试;

public class TryFinallyTest {

	private static int count = 0;
	public int ff(){
		try {
			System.out.println("a");
			count++;
			return count;
		} finally{
			System.out.println("finally 计算前=="+count);
			count++;
			System.out.println("finally 计算后=="+count);
			System.out.println("b");
		}
	}
	public static void main(String[] args) {
		System.out.println(new TryFinallyTest().ff());;

	}

}
