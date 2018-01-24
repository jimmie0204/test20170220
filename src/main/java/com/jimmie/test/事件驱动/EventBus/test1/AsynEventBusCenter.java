package com.jimmie.test.事件驱动.EventBus.test1;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.concurrent.Executors;

/** 
 * Created by zhangzh on 2017/1/10. 
 */  
public class AsynEventBusCenter {

    private static EventBus eventBus = new AsyncEventBus(Executors.newCachedThreadPool());

    private AsynEventBusCenter() {
  
    }  
  
    public static EventBus getInstance() {  
        return eventBus;  
    }  
  
    public static void register(Object obj) {  
        eventBus.register(obj);  
    }  
  
    public static void unregister(Object obj) {  
        eventBus.unregister(obj);  
    }  
  
    public static void post(Object obj) {  
        eventBus.post(obj);  
    }  
  
  
}  