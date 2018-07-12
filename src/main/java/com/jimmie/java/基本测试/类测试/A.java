package com.jimmie.java.基本测试.类测试;

public class A {
	
	public String msg = "success";
	
	public static Integer num = 3;
	
	public void pOut(){
		System.out.println("print msg:"+msg);
	}
	
	static class Aa{
		
		public Aa(){
			System.out.println(this);
		}
		
		public void print(){
			System.out.println("print parent num:"+num);
		}
	}


	public static  void print(int w){

		System.out.println(w);
	}

	public static void main(String[] args){
		Integer ll = null;

		print(ll);
	}
}
