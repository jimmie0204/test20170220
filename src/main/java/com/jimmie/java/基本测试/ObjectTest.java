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

    @Test
    public void test1(){
        String s = "100000000";
        double v = Double.parseDouble(s);System.out.println(v);

        int i = Integer.parseInt(s);
        System.out.println(i);

        System.out.println(1<<16);
        System.out.println(1<<15);
        short t = (short)(1<<15+1);
        System.out.println(t);
        short t2 = (short)((1<<15)-1);
        System.out.println(t2);
        short i1 = Short.parseShort(s);
        System.out.println(i1);

    }

    @Test
    public void test2(){
        Long i = 169114918L;
        System.out.println(i%512);
    }
}
