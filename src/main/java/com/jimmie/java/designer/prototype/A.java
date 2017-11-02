package com.jimmie.java.designer.prototype;

public class A implements Cloneable{

	public void dd() throws CloneNotSupportedException{
		this.clone();
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		new A().clone();
	}
}
