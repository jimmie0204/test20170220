package com.jimmie.java.基本测试.回调;/**
 * Created by jimmie on 2018/3/29.
 */

/**
 * @author jimmie
 * @create 2018-03-29 下午4:54
 */

public abstract class A {

    public void say(String name){
        doSay(name);
    }

    protected abstract void doSay(String name);

}
