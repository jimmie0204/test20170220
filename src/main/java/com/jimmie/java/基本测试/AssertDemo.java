package com.jimmie.java.基本测试;


public class AssertDemo {

    public static void main(String[] args) {
        
        test1(-5);
        test2(-3);
    }
    
    private static void test1(int a){
        assert a > 0;
        System.out.println(a);
    }
    private static void test2(int a){
        assert a > 0 : "something goes wrong here, a cannot be less than 0";
        System.out.println(a);
    }
}