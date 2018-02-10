package com.jimmie.java.基本测试.反射.test1;/**
 * Created by Jimmie on 2018/2/4.
 */

import org.junit.Test;

/**
 * @author jimmie
 * @create 2018-02-04 15:59
 */

public class TClassTest {
    public <T> void  getClassInfo(T clazz){
        System.out.println(clazz.getClass());
    }

    @Test
    public void test1(){
        String we = "ss";
        getClassInfo(we);
    }
}
