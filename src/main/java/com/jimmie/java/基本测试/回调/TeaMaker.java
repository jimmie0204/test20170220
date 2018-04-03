package com.jimmie.java.基本测试.回调;/**
 * Created by jimmie on 2018/3/29.
 */

/**
 * @author jimmie
 * @create 2018-03-29 下午4:54
 */

public abstract class TeaMaker {

    public void makeTea(String name){
        shaoshui();
        fangcha(name);
    }

    protected abstract void fangcha(String teaName);

    private void shaoshui() {
        System.out.println("水烧开到100度");
    }

}
