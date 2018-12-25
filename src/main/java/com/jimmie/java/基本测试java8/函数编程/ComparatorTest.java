package com.jimmie.java.基本测试java8.函数编程;/**
 * Created by jimmie on 2018/12/24.
 */

import com.google.common.collect.Lists;
import com.jimmie.java.基本测试.Student;
import com.jimmie.test.随机数.DateUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jimmie
 * @create 2018-12-24 下午3:15
 * <p>
 * https://blog.csdn.net/aitangyong/article/details/54880228
 * Comparator和Comparable的比较方法：返回>0-- 表示不需要换位置，排序的时候，比较的两者中的前者在前
 * 如果要按照升序排序，
    则o1 小于o2，返回-1（负数），相等返回0，01大于02返回1（正数）
    如果要按照降序排序
    则o1 小于o2，返回1（正数），相等返回0，01大于02返回-1（负数）
 */

public class ComparatorTest {


    private List<Student> ss = Lists.newArrayList();

    @Before
    public void before() {
        Date now = new Date();
        Student s1 = new Student();
        s1.setAge(1);
        s1.setName("a");
        s1.setBirthDay(new Date());

        Student s3 = new Student();
        s3.setAge(3);
        s3.setName("b");
        s3.setBirthDay(DateUtil.getDateAfter(now,4));

        Student s2 = new Student();
        s2.setAge(2);
        s2.setName("cccc");
        s2.setBirthDay(DateUtil.getDateAfter(now,2));

        Student s4 = new Student();
        s4.setAge(2);
        s4.setName("b");
        s4.setBirthDay(DateUtil.getDateAfter(now,1));

        ss = Lists.newArrayList(s1, s3, s2, s4);
    }

    @Test
    public void test() {
        System.out.println(ss);
//        ss.sort((o1, o2) -> o1.getAge()-o2.getAge());
        ss.sort(Comparator.comparingInt(Student::getAge));
        System.out.println(ss);
    }

    @Test
    public void test_2() {
        System.out.println(ss);
//        ss.stream().sorted((o1, o2) -> o1.getAge()-o2.getAge());
        List<Student> collect = ss.stream().sorted(Comparator.comparingInt(Student::getAge)).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test2() {
        System.out.println(ss);
        ss.sort((o1, o2) -> {
            if (o1.getAge() - o2.getAge() > 0)
                return -1;
            else
                return 1;
        });
        System.out.println(ss);
    }


    @Test
    public void test3() {
        System.out.println(ss);
        List<Student> collect = ss.stream().sorted(Comparator.comparing(Student::getAge).thenComparing(Student::getName)).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test4() {
        System.out.println(ss);
        List<Student> collect = ss.stream().sorted(Comparator.comparing(Student::getAge).thenComparing(Comparator.comparingInt(o -> o.getName().length()))).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test5() {
        System.out.println(ss);
        List<Student> collect = ss.stream().sorted(Comparator.comparing(o -> o.getBirthDay())).collect(Collectors.toList());
        System.out.println(collect);

        Student student = collect.stream().max((o1, o2) -> o1.getBirthDay().after(o2.getBirthDay()) ? 1 : -1).get();
        System.out.println(student);
    }

}
