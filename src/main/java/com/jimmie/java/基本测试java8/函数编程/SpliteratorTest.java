package com.jimmie.java.基本测试java8.函数编程;/**
 * Created by jimmie on 2018/12/6.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

/**
 * @author jimmie
 * @create 2018-12-06 下午6:10
 */

public class SpliteratorTest {

    @Test
    public void test(){
        List<String> arrs = new ArrayList<>();
        arrs.add("a");
        arrs.add("b");
        arrs.add("c");
        arrs.add("d");
        arrs.add("e");
        arrs.add("f");
        arrs.add("h");
        arrs.add("i");
        arrs.add("j");
        Spliterator<String> a =  arrs.spliterator();
        //此时结果：a:0-9（index-fence）
        Spliterator<String> b = a.trySplit();
        //此时结果：b:0-4,a:4-9
        Spliterator<String> c = a.trySplit();
        //此时结果：c:4-6,b:0-4,a:6-9
        Spliterator<String> d = a.trySplit();
        //此时结果：d:6-7,c:4-6,b:0-4,a:7-9
    }
}
