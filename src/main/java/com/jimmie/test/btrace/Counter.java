package com.jimmie.test.btrace;/**
 * Created by jimmie on 2018/4/13.
 */

/**
 * @author jimmie
 * @create 2018-04-13 下午1:08
 */

public class Counter {
    // 总数
    private static int totalCount = 0;

    public int add(int num) throws Exception {
        totalCount += num;
        sleep();

        return totalCount;
    }

    private void sleep() throws InterruptedException {
        Thread.sleep(1000);
    }
}