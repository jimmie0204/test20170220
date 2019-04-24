package com.jimmie.java.基本测试.集合类;/**
 * Created by jimmie on 2019/1/23.
 */

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jimmie
 * @create 2019-01-23 下午5:38
 */

public class MapListDiffTest {

    public static void main(String[] args) {
        List<String> big = Lists.newArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        List<String> small = Lists.newArrayList("1", "2", "3", "3", "2", "1");
        long a=System.currentTimeMillis();
        List<String> guava = GetDifferenceSet.getDifferenceSetByGuava(big, small);
        System.out.println("\r<br> 执行耗时 : "+(System.currentTimeMillis()-a)/1000f+" 秒 ");
        //为了显示一致，我给集合排个序，因为guava是按newHashSet集合来整的，newHashSet又是无序的,so ...
        Collections.sort(guava);
        a=System.currentTimeMillis();
        List<String> my = GetDifferenceSet.getDifferenceSetByMyself(big, small);
        System.out.println("\r<br> 执行耗时 : "+(System.currentTimeMillis()-a)/1000f+" 秒 ");
        System.out.println(guava.toString());
        System.out.println(my.toString());

        Map<String, String> bigMap = Maps.newHashMap();
        bigMap.put("1", "1");
        bigMap.put("2", "2");
        bigMap.put("3", "3");
        bigMap.put("4", "4");
        Map<String, String> smallMap = Maps.newHashMap();
        smallMap.put("1", "1");
        smallMap.put("2", "2");
        a=System.currentTimeMillis();
        Map<String, String> guavaMap = GetDifferenceSet.getDifferenceSetByGuava(bigMap, smallMap);
        System.out.println("\r<br> 执行耗时 : "+(System.currentTimeMillis()-a)/1000f+" 秒 ");
        System.out.println(guavaMap);
    }

    @Test
    public void test(){
        Map<String, String> bigMap = Maps.newHashMap();
        bigMap.put("1", "1");
        bigMap.put("2", "2");
        bigMap.put("3", "3");
        bigMap.put("4", "4");
        Map<String, String> smallMap = Maps.newHashMap();
        smallMap.put("5", "1");
        smallMap.put("2", "2");
        Long a=System.currentTimeMillis();
        Set<String> differenceSet = Sets.difference(bigMap.keySet(), smallMap.keySet());
        Map<String, String> guavaMap = GetDifferenceSet.getDifferenceSetByGuava(bigMap, smallMap);
        System.out.println("\r<br> 执行耗时 : "+(System.currentTimeMillis()-a)/1000f+" 秒 ");
        System.out.println(guavaMap);
        System.out.println(differenceSet);

    }

    @Test
    public void test2(){
        List<String> big = Lists.newArrayList("1", "2", "3");
        List<String> small = Lists.newArrayList("1", "2", "3", "3", "2", "1");

        System.out.println(big.containsAll(small) && small.containsAll(big));

    }
}
