package com.jimmie.test.fastjson.test3;/**
 * Created by jimmie on 2018/1/26.
 */

/**
 * @author jimmie
 * @create 2018-01-26 下午2:17
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.google.common.collect.Maps;
import org.junit.Test;

public class Demo1 {

    public class Student {
        private String name;
        private int age;
        private boolean isMale;
        private Student gf;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public boolean isMale() {
            return isMale;
        }

        public void setMale(boolean isMale) {
            this.isMale = isMale;
        }

        public Student getGf() {
            return gf;
        }

        public void setGf(Student gf) {
            this.gf = gf;
        }
    }

    public class School{
        private String sname;

        private int sage;


        public String getSname() {
            return sname;
        }

        public void setSname(String sname) {
            this.sname = sname;
        }

        public int getSage() {
            return sage;
        }

        public void setSage(int sage) {
            this.sage = sage;
        }


    }

    private static ValueFilter filter = new ValueFilter() {
        @Override
        public Object process(Object obj, String s, Object v) {
            if (v == null)
                return "";
            return v;
        }
    };

    public static void main(String[] args) {
        new Demo1().foo();
        new Demo1().bar();
    }

    private void foo() {
        System.out.println("foo()---------------------------");
        JSONObject j1 = new JSONObject();
        j1.put("name", "zhangsan");
        j1.put("age", 13);
        j1.put("isMale", true);
        j1.put("gf", null);
        Map<String, Object> fav = new HashMap<String, Object>();
        Set<String> books = new HashSet<String>();
        books.add("三国");
        books.add("史记");
        fav.put("history", books);
        String[] arts = new String[] {};
        fav.put("arts", arts);
        String[] musics = new String[] { "北京欢迎你", "画心" };
        fav.put("musics", musics);
        List<String> sports = new ArrayList<String>();
        fav.put("sports", sports);
        j1.put("fav", fav);
        List<Student> classmates = new ArrayList<Student>();
        classmates.add(new Student());
        Student lisi = new Student();
        lisi.setMale(false);
        lisi.setAge(11);
        classmates.add(lisi);
        Student zhangsan = new Student();
        zhangsan.setAge(13);
        zhangsan.setName("张三");
        zhangsan.setMale(true);
        zhangsan.setGf(lisi);
        classmates.add(zhangsan);
        j1.put("classmates", classmates);
        String str = null;
        j1.put("str", str);
        System.out.println(j1.toString());
        System.out
                .println(JSON.toJSONString(j1, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty));
        System.out.println(
                JSON.toJSONString(j1, filter, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty));
        System.out.println(JSON.toJSONString(j1, SerializerFeature.WriteNullStringAsEmpty));
        System.out.println(JSON.toJSONString(j1, filter, SerializerFeature.WriteNullStringAsEmpty));

        Map<String, JSONObject> m = new HashMap<String, JSONObject>();
        m.put("key", j1);
        System.out.println(
                JSON.toJSONString(m, SerializerFeature.WriteNonStringKeyAsString, SerializerFeature.WriteNullStringAsEmpty));
        System.out.println(JSON.toJSONString(m, filter, SerializerFeature.WriteNonStringKeyAsString,
                SerializerFeature.WriteNullStringAsEmpty));

    }

    private void bar() {
        System.out.println("bar()---------------------------");
        Student zhangsan = new Student();
        zhangsan.setAge(13);
        zhangsan.setName("张三");
        zhangsan.setMale(true);
        Student lisi = new Student();
        // lisi.setName("lisi");
        lisi.setMale(false);
        lisi.setAge(11);
        zhangsan.setGf(lisi);
        System.out.println(
                JSON.toJSONString(zhangsan, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty));
        System.out.println(JSON.toJSONString(zhangsan, SerializerFeature.WriteMapNullValue));
        System.out.println(JSON.toJSONString(zhangsan, SerializerFeature.WriteNullStringAsEmpty));
        System.out.println(JSON.toJSONString(zhangsan));
        System.out.println(JSON.toJSONString(zhangsan, filter));
        System.out.println(JSON.toJSONString(zhangsan, filter, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty));
    }

    @Test
    public void fg(){

        School school  = new School();
        school.setSage(123);
        school.setSname(null);

        System.out.println(
                JSON.toJSONString(school, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty));
    }

    @Test
    public void fg2(){

        Map school  = Maps.newHashMap();
        school.put("age",123);
        school.put("name",null);

        System.out.println(
                JSON.toJSONString(school, filter,SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty));
    }
}
