package com.jimmie.java.基本测试;

public class WhileTest {

	public static void main(String[] args) {
		boolean flag = true;
		do{
			if(flag){
				System.out.println("下面不走了，直接断开");
				break;
			}
			System.out.println("还能执行到我吗");
		}while(true);

	}

}
