package com.jimmie.java.designer.proxy;

public class HaiWaiFactory implements Sell{

	private Sell sell;
	
	public HaiWaiFactory() {
		this.sell = new ProducerFactory();
	}
	
	@Override
	public void sell() {
		System.out.println("我是海外厂家,代理工厂卖东西");
		sell.sell();
	}

}
