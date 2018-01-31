package com.jimmie.java.基本测试.集合类;
/**
 * Created by jimmie on 2018/1/29.
 */


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jimmie
 * @create 2018-01-29 上午11:43
 */

public class ListSetTest {

    @Test
    public void test1(){

        List<String> list = new ArrayList<>();

        list.add("aa");
        list.add("rr");

        boolean aa = list.contains("aa");
        System.out.println(aa);

    }

    @Test
    public void test2(){

        Set<String> set = new HashSet<>();

        set.add("aa");
        set.add("rr");

        boolean aa = set.contains("aa");
        System.out.println(aa);

    }

}
