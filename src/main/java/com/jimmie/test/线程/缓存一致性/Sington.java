package com.jimmie.test.线程.缓存一致性;

public class Sington {
	private static Sington instance;
	
	private Sington(){}

	public static Sington getInstance() {
		if (instance == null) // DCL
		{
			try {
				synchronized (Sington.class) {
					System.out.println("进入索。。。");
					if (instance == null)
						System.out.println("出功能键对象===============================================。。。");
						instance = new Sington(); // 有问题的代码！！！
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		return instance;
	}
}