package com.jimmie.java.基本测试.异常;/**
 * Created by jimmie on 2018/1/15.
 */

/**
 * @author jimmie
 * @create 2018-01-15 下午2:16
 * Exception in thread "main" java.lang.ExceptionInInitializerError
Caused by: java.lang.ArithmeticException: / by zero
at com.jimmie.java.基本测试.异常.AA.init(AA.java:21)
at com.jimmie.java.基本测试.异常.AA.<init>(AA.java:15)
at com.jimmie.java.基本测试.异常.AA.<clinit>(AA.java:11)
 */

public class AA {
//    private static AA aa = new AA();

    private AA(){//构造方法

        init();

    }

    public void init(){

        int i=1/0;
    }

    public static void main(String[] args){
//          AA a = new AA();

        AA a = new AA(){
            public void  init(){

                System.out.println("init 被重写");
            }
        };
    }
}
