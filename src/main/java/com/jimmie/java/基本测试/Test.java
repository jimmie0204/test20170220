package com.jimmie.java.基本测试;

public class Test {
	public static void change(String s){
        s="zhangsan";
    }
    
    public static void main(String[] args) {
        String s=new String("lisi");
        System.out.println(s);
        change(s);
        System.out.println(s);
    }
}
