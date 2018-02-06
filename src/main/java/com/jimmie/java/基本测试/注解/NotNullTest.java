package com.jimmie.java.基本测试.注解;/**
 * Created by jimmie on 2018/2/5.
 */

import javax.annotation.Nullable;

/**
 * @author jimmie
 * @create 2018-02-05 下午12:05
 */

public class NotNullTest {
    public void hello(@Nullable String name){
        System.out.println("hello "+name);
    }

    public static void main(String[] args){
      new NotNullTest().hello(null);
    }
}
