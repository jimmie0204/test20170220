package com.jimmie.java.基本测试.回调;/**
 * Created by jimmie on 2018/3/29.
 */

/**
 * @author jimmie
 * @create 2018-03-29 下午4:56
 */

public class TeaMakerTest {

    public static void main(String[] args){

        new TeaMaker(){

            @Override
            protected void fangcha(String name) {
                System.out.println("放"+name);
            }
        }.makeTea("龙井");

        new TeaMaker(){

            @Override
            protected void fangcha(String name) {
                System.out.println("放"+name);
            }
        }.makeTea("乌龙");
    }
}
