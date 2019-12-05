package com.jimmie.java.基本测试;

import org.junit.Test;

public class BaseTest2 {
    public static void change(String s) {
        s = "zhangsan";
    }

    public void hello(Integer i) {

    }

    @Test
    public void test1() {
        String s = new String("lisi");
        System.out.println(s);
        change(s);
        System.out.println(s);
    }


    @Test
    public void test2() {
        new BaseTest2().hello(null);
    }
}
