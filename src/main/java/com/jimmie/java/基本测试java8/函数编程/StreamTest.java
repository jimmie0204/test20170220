package com.jimmie.java.基本测试java8.函数编程;

import java.util.*;
import java.util.function.Function;
import java.util.stream.BaseStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import com.jimmie.java.基本测试.Student;

public class StreamTest {

    @Test
    public void test1() {
        List<Student> list = null;
        list.stream();
    }


    @Test
    public void test2() {
        List<String> al = Arrays.asList("a", "b", "c", "d");

        Normal n = new Normal();
        al.forEach(Normal::printStatic);
        al.forEach(n::printNoStatic);
        al.stream().forEach(Normal::printStatic);


    }

    @Test
    public void test3() {

        List<Person> list = new ArrayList();
        list.add(new Person(1, "haha"));
        list.add(new Person(2, "rere"));
        list.add(new Person(3, "fefe"));


        Map<Integer, Person> mapp = list.stream().collect(Collectors.toMap(Person::getId, Function.identity()));

        System.out.println(mapp);

        System.out.println(mapp.get(1).getName());

        Map<Integer, String> map = list.stream().collect(Collectors.toMap(Person::getId, Person::getName));

        System.out.println(map);
    }

    @Test
    public void test4() {
        Map<String, Integer> reverseOrderMap = new HashMap();
        reverseOrderMap.put("10001", 1);
        reverseOrderMap.put("10002", -1);
        reverseOrderMap.put("10003", 100);
        reverseOrderMap.put("10004", 0);
        reverseOrderMap.put("10005", 18);

        Map<String, Integer> newCollect = reverseOrderMap.entrySet().stream().filter(entry -> entry.getValue() != 0)
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
//		Stream<Map.Entry<String, Integer>> entryStream = reverseOrderMap.entrySet().stream().filter(entry -> entry.getValue() != 0);
//		Map<String, Integer> newCollect = entryStream.collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));

        System.out.println(reverseOrderMap);
        System.out.println(newCollect);
    }

    @Test
    public void test5() {
        List<List<Person>> listAll = new ArrayList<>();
        Person p1 = new Person(1, "ab");
        Person p2 = new Person(2, "bd");
        Person p3 = new Person(3, "be");
        Person p4 = new Person(4, "wb");
        Person p5 = new Person(5, "sd");
        Person p6 = new Person(6, "cc");
        List<Person> list1 = new ArrayList<>();
        List<Person> list2 = new ArrayList<>();

        list1.add(p1);
        list1.add(p2);
        list1.add(p3);
        list2.add(p4);
        list2.add(p5);
        list2.add(p6);
        listAll.add(list1);
        listAll.add(list2);


        List<Person> result = listAll.stream().parallel().flatMap(t -> t.stream().filter(p -> p.getName().contains("b")))
                .collect(Collectors.toList());
        System.out.println(result);

        String b = listAll.stream().parallel().flatMap(t -> t.stream().filter(p -> p.getName().contains("b")))
                .map(p -> p.getName()).collect(Collectors.joining("-"));
        System.out.println(b);

    }

    /**
     * Stream的map和flatMap的区别:
     * map会将一个元素变成一个新的Stream
     * 但是flatMap会将结果打平，得到一个单个元素
     */
    @Test
    public void test6() {
        /**获取单词，并且去重**/
        List<String> list = Arrays.asList("hello welcome", "world hello", "hello world",
                "hello world welcome");

        //map和flatmap的区别
        list.stream().map(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("---------- ");
        list.stream().flatMap(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList()).forEach(System.out::println);

        //实际上返回的类型是不同的
        List<Stream<String>> listResult = list.stream().map(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList());
        List<String> listResult2 = list.stream().flatMap(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList());

        System.out.println("---------- ");

        //也可以这样
        list.stream().map(item -> item.split(" ")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("================================================");

        /**相互组合**/
        List<String> list2 = Arrays.asList("hello", "hi", "你好");
        List<String> list3 = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");

        list2.stream().map(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList()).forEach(System.out::println);
        list2.stream().flatMap(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList()).forEach(System.out::println);

        //实际上返回的类型是不同的
        List<Stream<String>> list2Result = list2.stream().map(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList());
        List<String> list2Result2 = list2.stream().flatMap(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList());

    }

    @Test
    public void test7() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> collect = list.stream().parallel().map(num -> {
            System.out.println(Thread.currentThread().getName());
            return num * 2;
        })
                .filter(n -> {
                    System.out.println("====" + Thread.currentThread().getName());
                    return n > 4;
                }).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test8() {
        Map<Integer, String> map = Maps.newConcurrentMap();
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7);
//		List<String> collect = list.stream().parallel().map(num -> {
//			System.out.println(Thread.currentThread().getName());
//			return getMap(num, map);
//		}).collect(ArrayList<String>::new, (listNew, maptemp) -> listNew.addAll(maptemp.values()), List::addAll);
//		System.out.println(collect);

		/*List<String> collect2 = list.stream().map(num -> {
            System.out.println(Thread.currentThread().getName());
			return getMap(num, map);
		}).collect(ArrayList<String>::new, (listNew, maptemp) -> listNew.addAll(maptemp.values()), List::addAll);
		System.out.println(collect2);*/

        Map<Integer, String> reduce = list.stream().map(num -> {
            System.out.println(Thread.currentThread().getName());
            return num * 2;
        }).reduce(map, (m, poi) -> makeCityPoi(poi, m), (m1, m2) -> combineMap(m1, m2));
        System.out.println(Lists.newArrayList(reduce.values()));
        ;
        System.out.println("-----------------------------------------");

        Map<Integer, String> reduce2 = list.stream().parallel().map(num -> {
            System.out.println(Thread.currentThread().getName());
            return num * 2;
        }).reduce(map, (m, poi) -> makeCityPoi(poi, m), (m1, m2) -> combineMap(m1, m2));
        System.out.println(Lists.newArrayList(reduce2.values()));
        ;
        System.out.println("-----------------------------------------");

        Map<Integer, String> collect = list.stream().parallel().map(num -> {
            System.out.println(Thread.currentThread().getName());
            return num * 2;
        }).collect(Collectors.toMap(t -> t, t -> "===" + t, (v1, v2) -> v1 + v2));
        System.out.println(Lists.newArrayList(collect.values()));
        System.out.println("-----------------------------------------");

        //自定义collector，仿写toMap
        Map<Integer, String> collect2 = list.stream().parallel().map(num -> {
            System.out.println(Thread.currentThread().getName());
            return num * 2;
        }).collect(HashMap::new, (m, i) -> makeCityPoiConsumer(i, m), (m1, m2) -> combineMap(m1, m2));
        System.out.println(Lists.newArrayList(collect2.values()));
        System.out.println("-----------------------------------------");

        //自定义collector，仿写toMap
        Map<Integer, String> collect3 = list.stream().parallel().map(num -> {
            System.out.println(Thread.currentThread().getName());
            return num * 2;
        }).collect(HashMap::new, (m, i) -> makeCityPoiWithMergeConsumer(i, m), (m1, m2) -> combineMap(m1, m2));
        System.out.println(Lists.newArrayList(collect3.values()));
        System.out.println("-----------------------------------------");
    }

    @Test
    public void test8_1() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5);
        //自定义collector，仿写toMap
        Map<Integer, String> collect2 = list.stream().parallel().map(num -> {
            return num * 2;
        }).collect(HashMap::new, (m, i) -> makeCityPoiWithMergeConsumer(i, m), (m1, m2) -> combineMapConsumerFromToMap(m1, m2));
        System.out.println(Lists.newArrayList(collect2.values()));
        System.out.println("-----------------------------------------");
    }

    private Map<Integer, String> makeCityPoi(Integer poi, Map<Integer, String> m) {
        System.out.println(Thread.currentThread().getName() + "==" + m);
        m.put(poi, "===" + poi);
        return m;
    }

    private void makeCityPoiConsumer(Integer poi, Map<Integer, String> m) {
        System.out.println(Thread.currentThread().getName() + "==" + m);
        m.put(poi, "===" + poi);
    }

    private void makeCityPoiWithMergeConsumer(Integer poi, Map<Integer, String> m) {
        System.out.println(Thread.currentThread().getName() + "==" + m);
        m.merge(poi, "===" + poi, (v1, v2) -> v1 + v2);
    }

    //Stream.concat新产生了一个map,没有把结果放入第一个容器中，所以导致返回列表是第一个map的结果
    private void combineMapConsumer(Map<Integer, String> m1, Map<Integer, String> m2) {

        System.out.println(Thread.currentThread().getName() + "==m1==" + m1 + "==m2==" + m2);
        Stream.concat(m1.entrySet().stream(), m2.entrySet().stream())
                .collect(Collectors.toMap(t -> t.getKey(), t -> t.getValue(), (v1, v2) -> v1 + v2));
    }

    //结果放入了原map中
    private void combineMapConsumerFromToMap(Map<Integer, String> m1, Map<Integer, String> m2) {

        System.out.println(Thread.currentThread().getName() + "==m1==" + m1 + "==m2==" + m2);
        for (Map.Entry<Integer, String> e : m2.entrySet())
            m1.merge(e.getKey(), e.getValue(), (v1, v2) -> v1 + v2);
    }

    private Map<Integer, String> combineMap(Map<Integer, String> m1, Map<Integer, String> m2) {

        System.out.println(Thread.currentThread().getName() + "==m1==" + m1 + "==m2==" + m2);
        return Stream.concat(m1.entrySet().stream(), m2.entrySet().stream())
                .collect(Collectors.toMap(t -> t.getKey(), t -> t.getValue(), (v1, v2) -> v1 + v2));
    }


    private Map<Integer, String> getMap(Integer num, Map<Integer, String> map) {
        map.put(num, num + "==");
        return map;
    }


    @Test
    public void test9() {
        Map<Integer, String> m1 = Maps.newHashMap();
        m1.put(1, "a");
        m1.put(2, "b");
        Map<Integer, String> m2 = Maps.newHashMap();
        m2.put(1, "A");
        m2.put(3, "C");
        Map<Integer, String> integerStringMap = combineMap(m1, m2);
        System.out.println(integerStringMap);
        System.out.println(Lists.newArrayList(integerStringMap.values()));
    }


    @Test
    public void test10() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5);
        final Integer[] bad = {-1};
        boolean b = list.stream().allMatch(t -> {
            bad[0] = t;
            return t < 3;
        });

        System.out.println(bad[0]);

    }

}
