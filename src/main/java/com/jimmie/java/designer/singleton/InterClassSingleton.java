package com.jimmie.java.designer.singleton;

import java.util.Random;

/**
 * @author jimmie
 * @create 2019-09-19 上午11:47
 */
public class InterClassSingleton implements HelloSingleInstance.ITestSingleInstance {

    private InterClassSingleton(){

        System.out.println("创建一个InterClassSingleton");
    }

    public static InterClassSingleton getInstance(){
        return InterClassSingletonHolder.interClassSingleton;
    }

    public static class InterClassSingletonHolder{
        public final static InterClassSingleton interClassSingleton = new InterClassSingleton();;
    }

    //test内容
    private final static Random random = new Random();
    private int id = random.nextInt(1000);

    @Override
    public int getId() {
        return id;
    }
}
