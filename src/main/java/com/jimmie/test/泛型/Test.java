package com.jimmie.test.泛型;

import java.util.Map;

public class Test {

    public static <T> void out(T... args) {
        for (T t : args) {
            System.out.println(t);
        }
    }
    
    public static <K,V,T> T out2(Map<K,V> map,T args) {
        return args;
    }


    public static void main(String[] args) {
        out("finding", 123, 11.11, true);
        System.out.println(out2(null, 1));;
    }
}