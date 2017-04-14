package com.jimmie.test.对象池;

import java.util.concurrent.TimeUnit;

public class ZeusPoolTest {

	public static void main(String[] args) throws InterruptedException {
		ZeusPoolConfig config = new ZeusPoolConfig();
		config.setValidTime(1000L);
		config.setMaxIdle(1);
		config.setMinIdle(1);//最大最小空闲对象
		config.setInitNum(5);
		
		ZeusPool zeusPool = new ZeusPool(new ZeusFactory(), config);
		
		for(int i=0;i<5;i++){
			Zeus zeus = zeusPool.getResource();
			System.out.println(zeus.getAge());
			System.out.println(zeus);
			TimeUnit.SECONDS.sleep(5);
//			zeusPool.returnResource(zeus);
		}
		
	}
}
