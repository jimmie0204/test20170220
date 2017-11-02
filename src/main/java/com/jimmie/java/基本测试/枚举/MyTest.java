package com.jimmie.java.基本测试.枚举;

public class MyTest {

	enum Contry{
		US(1,"N"),China(2,"E");
		private int i ;
		
		private String or;
		
		private Contry(int code,String or){
			this.i = code;
			this.or = or;
		}
		
	}
	public static void main(String[] args) {
		System.out.println(MyTest.Contry.US.i);
		Contry[] a= MyTest.Contry.values();
		System.out.println(a[0].or);

	}

}
