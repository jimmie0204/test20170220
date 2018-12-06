package com.jimmie.java.基本测试java8.函数编程;/**
 * Created by jimmie on 2018/12/5.
 */

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author jimmie
 * @create 2018-12-05 下午8:14
 */

public class FilterTest {

    public static <T> List<T> filter(Stream<T> stream, Predicate<T> predicate) {
        return stream.reduce(new ArrayList<T>(), (acc, t) -> {
            if (predicate.test(t)) {
//                List<T> lists = new ArrayList<T>(acc);
//                lists.add(t);
                acc.add(t);
                return acc;
            }
            return acc;
        }, (List<T> left, List<T> right) -> {
            List<T> lists = new ArrayList<T>(left);
            lists.addAll(right);
            return lists;
        });
    }

    public static <T> List<T> filter2(Stream<T> stream, Predicate<T> predicate) {
        return stream.collect(ArrayList::new, (acc, t) -> {
            if (predicate.test(t))
                acc.add(t);
        }, ArrayList::addAll);
    }


    @Test
    public void test() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<Integer> listFilter1 = FilterTest.filter(list.stream(), t -> t > 2);
        System.out.println(listFilter1);

        List<Integer> listFilter2 = FilterTest.filter2(list.stream(), t -> t > 2);
        System.out.println(listFilter2);


    }

}
