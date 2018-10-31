package com.jimmie.test.线程.阻塞;/**
 * Created by jimmie on 2018/10/29.
 */

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author jimmie
 * @create 2018-10-29 下午5:36
 */

public class SynFunction {

    public synchronized void fun(){
        System.out.println(Thread.currentThread().getName()+"进入同步代码方法");

        //三种阻塞方式的差异

        /*try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

//        LockSupport.park();

        if(!Thread.interrupted()){
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println(Thread.currentThread().getName()+"被中断过");

        }
    }


}
