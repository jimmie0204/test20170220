package com.jimmie.java.基本测试;/**
 * Created by jimmie on 2018/1/25.
 */

import org.junit.*;
import org.junit.Test;

/**
 * @author jimmie
 * @create 2018-01-25 下午4:02
 */

public class BaseTest {
    public int partition(Object key, int numPartitions) {
        return Integer.parseInt(key.toString()) % numPartitions;
    }

    public int partition2(Object key, int numPartitions) {
        return Integer.parseInt(key.toString());
    }

    @org.junit.Test
    public  void test1(){
        Long key = 123121231231231233L;
        System.out.println(Integer.parseInt(key.toString()));
        System.out.println(partition2(key,3));
    }

    public void hello(Object p){
        System.out.println(p.getClass());
    }
    @Test
    public void test2(){

        String we = "sd";
        hello(we);
    }
    @Test
    public void test3(){

       Integer i = 100;
       System.out.println(i/11);
    }

    public void f1(int num){
        System.out.println("num=="+num);

    }

    @Test
    public void test4(){
        new BaseTest().f1(0);
    }

    @Test
    public void test5(){
        System.out.println(52903566%512);
    }
}
