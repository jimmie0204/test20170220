package com.jimmie.java.基本测试java8;/**
 * Created by Jimmie on 2018/6/3.
 */

/**
 * @author jimmie
 * @create 2018-06-03 15:34
 */

public class Person {

    private Integer id;
    private String name;

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }



}