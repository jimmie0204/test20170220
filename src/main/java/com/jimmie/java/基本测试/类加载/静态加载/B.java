package com.jimmie.java.基本测试.类加载.静态加载;

public class B {

    public static String name = "zeus";

    public static int count = 1;

    public int num = 23;

    static {
        System.out.println(name);
    }

    {
        System.out.println(name + "===");
    }

}
