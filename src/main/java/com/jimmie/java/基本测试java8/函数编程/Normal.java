package com.jimmie.java.基本测试java8.函数编程;/**
 * Created by Jimmie on 2018/6/3.
 */

import java.util.Random;

/**
 * @author jimmie
 * @create 2018-06-03 15:25
 */

public class Normal {

    public static void printStatic(String name){
        System.out.println("hello static :"+name);
    }


    public void printNoStatic(String name){
        System.out.println("hello no static :"+name);
    }

    public Integer getNum(){
        return new Random().nextInt();
    }
}
