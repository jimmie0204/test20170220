package com.jimmie.java.基本测试.重载重写;/**
 * Created by jimmie on 2018/1/15.
 */

/**
 * @author jimmie
 * @create 2018-01-15 下午2:16
 */

public class AA {

    private AA(){//构造方法

        init();

    }

    public void init(){

        int i=1/0;
    }

    public static void main(String[] args){
//          AA a = new AA();

        AA a = new AA(){
            public void  init(){

                System.out.println("init 被重写");
            }
        };
    }
}
