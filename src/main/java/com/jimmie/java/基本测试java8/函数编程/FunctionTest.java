package com.jimmie.java.基本测试java8.函数编程;/**
 * Created by jimmie on 2018/12/5.
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author jimmie
 * @create 2018-12-05 下午5:25
 */

public class FunctionTest {

    public static <T, S, Q, R> Function<BiFunction<S, Q, R>, Function<T, R>> op(Function<T, S> funcx, Function<T, Q> funcy) {
        return opFunc -> aT -> opFunc.apply(funcx.apply(aT), funcy.apply(aT));
    }

    @Test
    public void test1() {
        System.out.println(op(x -> x.toString().length(), y -> y + ",world").apply((x, y) -> x + " " + y).apply("hello"));
    }


    public static <T, S, K, R> List<R> mergeList(List<S> srcList, List<T> destList,
                                                 Function<S, K> skeyFunc, Function<T, K> dkeyFunc,
                                                 BiFunction<S, T, R> mergeFunc) {
        return join(destList, mapKey(srcList, skeyFunc)).apply(dkeyFunc, (BiFunction) mergeFunc);

    }

    public static <T, K> Map<K, T> mapKey(List<T> list, Function<T, K> keyFunc) {
        return list.stream().collect(Collectors.toMap(keyFunc, t -> t, (k1, k2) -> k1));
    }

    public static <T, S, K, R> BiFunction<Function<T, K>, BiFunction<S, T, R>, List<R>> join(List<T> destList, Map<K, S> srcMap) {
        return (dkeyFunc, mergeFunc) -> destList.stream().map(
                dest -> {
                    K key = dkeyFunc.apply(dest);
                    S src = srcMap.get(key);
                    return mergeFunc.apply(src, dest);
                }).collect(Collectors.toList());
    }

    @Test
    public <T, S> void test2() {
        System.out.println(mergeList(Arrays.asList(1, 2), Arrays.asList("an", "a")
                , s -> s, t -> t.toString().length(), (s, t) -> s + t));

    }

}
