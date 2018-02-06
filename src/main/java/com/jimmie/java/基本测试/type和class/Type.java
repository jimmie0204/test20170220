package com.jimmie.java.基本测试.type和class;/**
 * Created by jimmie on 2018/2/5.
 */

import com.jimmie.test.bean操作.Student;
import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jimmie
 * @create 2018-02-05 下午4:52
 */

public class Type {

    @Test
    public void test1(){
        Map<String,Student> map = new HashMap<>();
//        ((ParameterizedType)(map.getClass())).getActualTypeArguments();
    }
}
