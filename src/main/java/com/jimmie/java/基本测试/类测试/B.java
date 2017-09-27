package com.jimmie.java.基本测试.类测试;

public class B {
	{//构造块在创建对象时会被调用，每次创建对象时都会被调用，并且优先于类构造函数执行。 构造块中定义的变量是局部变量。
		System.out.println("我曹");
	}
	public String msg = "success";
	
	public static Integer num = 3;
	
	public void pOut(){
		System.out.println("print msg:"+msg);
	}
	
	public static void main(String[] args) {
		new A.Aa();
	}

}
