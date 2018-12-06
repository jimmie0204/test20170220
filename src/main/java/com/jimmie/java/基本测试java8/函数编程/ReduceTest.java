package com.jimmie.java.基本测试java8.函数编程;/**
 * Created by jimmie on 2018/12/5.
 */

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author jimmie
 * @create 2018-12-05 下午8:33
 * 三个参数，第三个参数只有并行运行时才有作用，作用是是每次并行结果的聚合函数
 */

public class ReduceTest {

    private Stream<Integer> st = null;

    @Before
    public void before() {
        st = Stream.of(1, 2, 3, 4, 5, 6);

    }

    //一个参数的reduce,返回optional
    @Test
    public void test() {
        Integer sum = st.reduce((a, b) -> a + b).get();
        System.out.println(sum);
    }

    //两个参数的reduce
    @Test
    public void test2() {
        Integer sum = st.reduce(9, (a, b) -> a + b);
        System.out.println(sum);
    }

    //三个参数的reduce,串行，qw123456
    @Test
    public void test3() {
        String sum = st.reduce("qw", (m, n) -> m + n, (a, b) -> a + b);
        System.out.println(sum);
    }

    //三个参数的reduce，并行,qw1qw2qw3qw4qw5qw6
    @Test
    public void test4() {
        String sum = st.parallel().reduce("qw", (m, n) -> m + n, (a, b) -> a + b);
        System.out.println(sum);

        //等价于
        Optional<String> reduce = st.map(n -> "qw" + n).reduce((a, b) -> a + b);
        System.out.println(reduce.get());
//        这种方式有助于理解并行三个参数时的场景，实际上就是第一步使用accumulator进行转换
//        （它的两个输入参数一个是identity, 一个是序列中的每一个元素），由N个元素得到N个结果；
//        第二步是使用combiner对第一步的N个结果做汇总。

    }

    //三个参数的reduce,串行，22
    @Test
    public void test5() {
        Integer sum = st.reduce(1, (m, n) -> m + n, (a, b) -> a + b);
        System.out.println(sum);
    }

    //三个参数的reduce，并行,27
    @Test
    public void test6() {
        Integer sum = st.parallel().reduce(1, (m, n) -> m + n, (a, b) -> a + b);
        System.out.println(sum);
    }

    //三个参数的reduce，并行,27
    @Test
    public void test7() {
        Stream<String> s1 = Stream.of("aa", "ab", "c", "ad");

//模拟Filter查找其中含有字母a的所有元素，由于使用了r1.addAll(r2)，其打印结果将不会是预期的aa ab ad
        Predicate<String> predicate = t -> t.contains("a");
        s1.parallel().reduce(new ArrayList<String>(), (r, t) -> {if (predicate.test(t)) r.add(t);  return r; },
                (r1, r2) -> {r1.addAll(r2); return r1; }).stream().forEach(System.out::println);
    }


}
