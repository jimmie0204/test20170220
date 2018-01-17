package com.jimmie.test.事件驱动.EventBus.test1;

public class EventBusTest2 {

	 public static void main(String[] args) throws InterruptedException {  
		  
	        DataObserver1 observer1 = new DataObserver1();  
	        EventBusCenter.register(observer1);

	        System.out.println("============   start  ====================");  
	  
	        // 只有注册的参数类型为String的方法会被调用
	        EventBusCenter.post(123);
		 	EventBusCenter.post(11);

	        System.out.println("============    end           =============");
	    }
}
