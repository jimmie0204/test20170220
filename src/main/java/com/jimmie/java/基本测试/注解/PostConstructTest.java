package com.jimmie.java.基本测试.注解;/**
 * Created by jimmie on 2018/1/17.
 */

import javax.annotation.PostConstruct;

/**
 * @author jimmie
 * @create 2018-01-17 上午11:45
 */

public class PostConstructTest {


    private static class A{

        public A() {
            System.out.println("A构造函数");
        }

        @PostConstruct//只在servlet环境中有作用
        public void start(){
            System.out.println("PostConstruct方法==");
        }

    }

    public static void main(String[] args){
      new A();
    }


}
