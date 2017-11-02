package com.jimmie.java.designer.proxy;

public class Market implements Sell{

	private int size;
	public Sell sell;
	
	/*	public Market(){
		
	}
	
	public Market(Sell se){
		if(se!=null)
			sell = se;
		else
			sell = new ProducerFactory();
	}*/
	public Market(){
		sell = new ProducerFactory();
	}
	@Override
	public void sell() {
//		if(getSize()>=10){
			System.out.println("我是超市，代厂家东西");
			sell.sell();
/*		}else
			System.out.println("资格不够，不能代销");*/

	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

}
