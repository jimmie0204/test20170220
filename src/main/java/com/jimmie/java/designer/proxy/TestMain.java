package com.jimmie.java.designer.proxy;

import java.lang.reflect.Proxy;


public class TestMain {

	public static void main(String[] args) {
		Sell mark = new Market();

/*		mark.setSize(0);
		mark.sell();*/
//		mark.setSize(11);
		mark.sell();
		
		//autoproxy
		Sell sell = (Sell)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{Sell.class}, new AutoProxy());
		sell.sell();
		
		Sell sell2 = new HaiWaiFactory();
		sell2.sell();
	}

}
