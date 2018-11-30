package com.jimmie.java.基本测试.all.dataStructure.annotation.runtime;

public class UserBean {

    @Alias("user_name")
    public String userName;

    @Alias("user_id")
    private long userId;

    public UserBean(String userName, long userId) {
        this.userName = userName;
        this.userId = userId;
    }

    public String getName() {
        return userName;
    }

    public long getId() {
        return userId;
    }

    @RunTest(value = "static_method", id = 1)
    public static void staticMethod() {
        System.out.printf("I'm a static method\n");
    }

    @RunTest(value = "public_method", id = 2)
    public void publicMethod() {
        System.out.println("I'm a public method\n");
    }

    @RunTest(value = "private_method", id = 3)
    private void privateMethod() {
        System.out.println("I'm a private method\n");
    }

    @RunTest(id = 4)
    public void testFailure() {
        throw new RuntimeException("Test failure");
    }
}
