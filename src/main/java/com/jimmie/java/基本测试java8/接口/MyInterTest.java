package com.jimmie.java.基本测试java8.接口;/**
 * Created by jimmie on 2018/11/30.
 */


import org.junit.Test;

/**
 * @author jimmie
 * @create 2018-11-30 下午3:41
 */

public class MyInterTest {

    @Test
    public void test(){

        MyInterImpl man = new MyInterImpl();
        man.df("jimmie");        //通过man对象调用MyInter接口的默认方法df()、
        MyInter.sf(); //直接调用接口的静态方法。
    }
}
