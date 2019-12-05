package com.jimmie.java.基本测试.all.common.classloader.hotdeploy;

/**
 * @author jimmie
 * @create 2019-10-09 下午5:04
 */
public class Account {

    public void operation() {
        System.out.println("operation...kkk");
        try {
            Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
