package com.jimmie.java.基本测试.type和class;/**
 * Created by jimmie on 2018/2/5.
 */

import com.jimmie.java.基本测试.类测试.C;
import com.jimmie.test.bean操作.Student;
import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;

import java.lang.ref.WeakReference;
import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.lang.reflect.Type;

/**
 * @author jimmie
 * @create 2018-02-05 下午4:52
 */

public class TypeTest {

    @Test
    public void test1(){
        Map<String,Student> map = new HashMap<>();
        Class<? extends Map> aClass = map.getClass();
//        aClass.get
//        ((ParameterizedType)(aClass)).getActualTypeArguments();
    }

    @Test
    public void test2(){
        List<Student> listUser = new ArrayList<>();
        Type genType = listUser.getClass().getGenericSuperclass();

        Class templatClazz = null;

        if(ParameterizedType.class.isInstance(genType))
        {
            //无法获取到User类，或者可能获取到错误的类型，如果有同名且不带包名的泛型存在
            ParameterizedType parameterizedType = (ParameterizedType) genType;
            templatClazz = (Class) parameterizedType.getActualTypeArguments()[0];
        }
    }

    @Test
    public void test3(){
        C c = new C();
        C c2 = new C(){};
        System.out.println(c.getClass());
        System.out.println(c.getClass());
        System.out.println(c2.getClass());
        System.out.println(c2.getClass().getSuperclass());
        List<Student> listUser = new ArrayList<>();
        List<Student> listUser2 = new ArrayList<Student>(){};
        System.out.println(listUser.getClass());
        System.out.println(listUser2.getClass());
        System.out.println(listUser2.getClass().getSuperclass());

        try {
//            System.in.read();

            List<C> clist = new LinkedList<>();

            boolean running = true;
            int num = 0;
            while (running){

                if(num++>10000000){
                    running=false;
                }
                C ctemp = new C(){};
                clist.add(ctemp);
                Thread.sleep(RandomUtils.nextInt(2)*1000);
                System.out.println(num+"============");

            }

            System.out.println("end=======");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
