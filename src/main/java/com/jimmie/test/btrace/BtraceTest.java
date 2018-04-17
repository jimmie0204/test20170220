package com.jimmie.test.btrace;/**
 * Created by jimmie on 2018/4/13.
 */

/**
 * @author jimmie
 * @create 2018-04-13 下午1:08
 */

import java.util.Random;
public class BtraceTest {

    public static void main(String[] args) throws Exception {

        Random random = new Random();

        // 计数器
        Counter counter = new Counter();
        while (true) {
            // 每次增加随机值
            counter.add(random.nextInt(10));
            Thread.sleep(1000);
        }
    }
}