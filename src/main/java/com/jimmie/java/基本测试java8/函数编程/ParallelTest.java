package com.jimmie.java.基本测试java8.函数编程;/**
 * Created by jimmie on 2018/12/6.
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author jimmie
 * @create 2018-12-06 下午2:07
 */

public class ParallelTest {

    @Test
    public void test(){
        Map<Integer, List<Integer>> collect = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 9, 8, 0, 1)
                .stream()
                .parallel()
                .collect(Collectors.groupingBy(x -> x % 10));
        collect.forEach((x, y) -> System.out.println(x + ":" + y));

    }

    @Test
    public void test2(){
        String property = System.getProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "12");
        System.out.println(property);

    }

    @Test
    public void test3() throws InterruptedException {
        List<Integer> collect = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 9, 8, 0, 1)
                .stream()
                .parallel().map(num -> num + 1).collect(Collectors.toList());

        System.out.println(collect);

        TimeUnit.SECONDS.sleep(1000);

    }

    @Test
    public void test4() throws InterruptedException {
        Stream<Integer> peek = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 9, 8, 0, 1)
                .stream().map(m->{System.out.println(m);return m+1;}).peek(System.out::println);

    }
}
