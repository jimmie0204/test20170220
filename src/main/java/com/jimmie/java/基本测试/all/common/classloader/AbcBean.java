package com.jimmie.java.基本测试.all.common.classloader;

import java.util.Date;

public class AbcBean {
    
    @Override
    public String toString() {
        return "AbcBean [name=" + name + ", age=" + age + "]";
    }
    
    String name;
    int age;
    Date birthDay;
    
    public Date getBirthDay() {
        return birthDay;
    }
    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
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
    
    public void greeting() {
        System.out.println("AbcBean.greeting()");
    }
}