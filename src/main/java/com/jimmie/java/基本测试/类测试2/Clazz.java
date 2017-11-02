package com.jimmie.java.基本测试.类测试2;

public class Clazz {

	  {
		  System.out.println("匿名构造方法");
	  }
	  
	  static{
		  System.out.println("静态代码块");
	  }
	  public Clazz(){
		  System.out.println("无参构造函数");
	  }
	  
	  public static void main(String[] args) {
		new Clazz();
		new Clazz();
	}
	  
}
