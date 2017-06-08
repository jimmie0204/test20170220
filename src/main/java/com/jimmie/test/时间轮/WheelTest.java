package com.jimmie.test.时间轮;

import java.util.concurrent.TimeUnit;

public class WheelTest {
	
	public static void main(String[] args) throws Exception{
		TimingWheelAsynExpiredEmptyQ<String> w = new TimingWheelAsynExpiredEmptyQ<String>(1,3,TimeUnit.SECONDS);
		
		w.addExpirationListener(new JimmieListener());
		
		w.start();
		
		w.add("werwet");
		w.add("548");
		
//		TimeUnit.SECONDS.sleep(1);
		
		w.add("548");
		w.add("oppp");
		
		System.in.read();
	}
}  