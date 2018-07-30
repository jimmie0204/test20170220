package com.jimmie.java.基本测试.类测试.instanceoftest;/**
 * Created by jimmie on 2018/6/22.
 */

/**
 * @author jimmie
 * @create 2018-06-22 下午6:08
 */

public class InstanceTest {

    public interface A{

    }

    public interface B{

    }



    public static void main(String[] args){
        Clazz clazz = new Clazz();
        A a = (A) clazz;

        //AB被同一个类clazz继承
      System.out.println(a instanceof B);
    }


}
