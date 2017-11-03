package com.jimmie.java.基本测试.all.designPattern.singleton;

/**
 * Created by Jay on 3/30/17.
 */
public class Singleton {
    private static Singleton singleton = new Singleton();
    public static int counter1;
    public static int counter2 = 0;
    private Singleton() {
        counter1++;
        counter2++;
    }
    public static Singleton getSingleton() {
        return singleton;
    }
}