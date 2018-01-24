package com.jimmie.test.事件驱动.EventBus.test1;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;

import java.util.concurrent.TimeUnit;

/** 
 * Created by zhangzh on 2017/1/10. 
 */  
public class DataObserver3 {
    /** 
     * post() 不支持自动装箱功能,只能使用Integer,不能使用int,否则handlersByType的Class会是int而不是Intege 
     * 而传入的int msg参数在post(int msg)的时候会被包装成Integer,导致无法匹配到 
     */  
    @Subscribe
    public void func(Integer msg) {
        System.out.println("Integer msg: " + msg+"==="+Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println("Integer msg: " + msg);
    }  

    @Subscribe
    public void func2(String msg) {
        /*try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("Integer msg2: " + msg+"==="+Thread.currentThread().getName());
    }  
}  