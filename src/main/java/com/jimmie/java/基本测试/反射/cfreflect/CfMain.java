package com.jimmie.java.基本测试.反射.cfreflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author jimmie
 * @create 2019-10-11 上午11:44
 * 结论：子类的方法注解
 */
public class CfMain {

    public static void main(String[] args) throws NoSuchMethodException {
        Method run = Tiger.class.getDeclaredMethod("run");
        Annotation[] annotations = run.getAnnotations();

        Method run2 = Animal.class.getDeclaredMethod("run");
        Annotation[] annotations2 = run2.getAnnotations();

        Animal animal = new Tiger();
        Method run3 = animal.getClass().getDeclaredMethod("run");
        Annotation[] annotations3 = run3.getAnnotations();
        System.out.println("end==");

    }
}
