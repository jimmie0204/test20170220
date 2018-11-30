package com.jimmie.java.基本测试java8.接口;/**
 * Created by jimmie on 2018/11/30.
 */

/**
 * @author jimmie
 * @create 2018-11-30 下午3:40
 */

public class MyInterImpl implements MyInter{//MyInterImpl类实现MyInter接口
    @Override
    public int printName(String name) {
        System.out.println("printName 实现类打印输出");
        return 0;
    }
}
