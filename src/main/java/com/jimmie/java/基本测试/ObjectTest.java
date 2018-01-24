package com.jimmie.java.基本测试;/**
 * Created by jimmie on 2018/1/18.
 */

import org.junit.*;

/**
 * @author jimmie
 * @create 2018-01-18 上午11:02
 */

public class ObjectTest {
    @org.junit.Test
    public void test(){

        Student s = new Student();

        System.out.println(s.toString());
        System.out.println(Integer.parseInt(s.toString()));
    }
}
