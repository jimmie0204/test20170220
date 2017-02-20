package com.jimmie.test.事件驱动.event.demo;

public class DemoListener implements java.util.EventListener{

	//EventListener是所有事件侦听器接口必须扩展的标记接口、因为它是无内容的标记接口、     
    //所以事件处理方法由我们自己声明如下：
	
	public void handleEvent(DemoEvent de) {     
        System.out.println("Inside listener1...");     
        de.say();//回调     
 } 
}
