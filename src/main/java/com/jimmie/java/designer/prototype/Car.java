package com.jimmie.java.designer.prototype;

public abstract class Car implements Cloneable{

	String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	int price;
	
	public abstract Car fuzhi();
}
