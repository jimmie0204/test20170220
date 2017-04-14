package com.jimmie.test.对象池;

public class ZeusPoolTest {

	public static void main(String[] args) {
		ZeusPoolConfig config = new ZeusPoolConfig();
		config.setValidTime(1000L);
		config.setMaxIdle(3);
		config.setMinIdle(3);
		config.setInitNum(5);
		
		ZeusPool zeusPool = new ZeusPool(new ZeusFactory(), config);
		
		for(int i=0;i<5;i++){
			Zeus zeus = zeusPool.getResource();
			System.out.println(zeus.getAge());
			System.out.println(zeus);
			zeusPool.returnResource(zeus);
		}
		
	}
}
