package com.jimmie.test.位运算;

public class Test1 {

	public static void main(String[] args) {
		System.out.println(16&1);

		System.out.println(Integer.toBinaryString(15));
//		System.out.format("%x",135);
		System.out.println(2<<0);
		System.out.println(2<<1);
		System.out.println(2<<2);
		
		System.out.println("=============");
		int READ = 1 << 0;
		int WRITE = 1 << 1;
		int CREATE = 1 << 2;
		int DELETE = 1 << 3;
		int ADMIN = 1 << 4;
		
		System.out.println(1<<8);
		
		int auth = READ | WRITE |CREATE;
		System.out.println(auth);
		System.out.println(CREATE & auth); //结果为4
		System.out.println(DELETE & auth); //结果为0
		
		System.out.println();
		
		
	}

}
