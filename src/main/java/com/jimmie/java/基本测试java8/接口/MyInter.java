package com.jimmie.java.基本测试java8.接口;/**
 * Created by jimmie on 2018/11/30.
 */

/**
 * @author jimmie
 * @create 2018-11-30 下午3:39
 */

public interface MyInter {
    default void df(String name) {    //声明一个接口的默认方法
        System.out.println("i'am default f");
        sf();        //调用本接口的类方法
        printName(name);
    }

    static void sf() {    //声明一个接口的类方法
        System.out.println("i'am static f");

    }

    int printName(String name);
}