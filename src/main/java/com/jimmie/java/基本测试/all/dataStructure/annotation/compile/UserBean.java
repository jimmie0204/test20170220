package com.jimmie.java.基本测试.all.dataStructure.annotation.compile;

/**
 * Created by Jay on 5/3/17.
 */
@Generator
public class UserBean {

    @Generator
    String userName;

    @Generator
    public String getUserName() {
        return userName;
    }
}
