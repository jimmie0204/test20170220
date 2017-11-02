package com.jimmie.java.designer.proxy;

public class ProducerFactory implements Sell{

	@Override
	public void sell() {
		System.out.println("我是厂家直销");
		
	}

}
