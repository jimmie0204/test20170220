package com.jimmie.test.时间轮;

import java.util.concurrent.TimeUnit;

public class JimmieListener  implements ExpirationListener<String> {

	@Override
	public void expired(String expiredObject) {
		System.out.println(expiredObject+"已失效=====");
		try {
			TimeUnit.SECONDS.sleep(5);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
