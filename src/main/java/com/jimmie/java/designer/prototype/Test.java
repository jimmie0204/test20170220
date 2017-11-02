package com.jimmie.java.designer.prototype;

public class Test {

	public static void main(String[] args) {
		BMWCar c = new BMWCar();
		c.setName("bmw1000");
		c.setPrice(100);
		BMWCar v = (BMWCar)c.fuzhi();
		System.out.println(c);
		System.out.println(v);
		System.out.println(c.getPrice());
		System.out.println(v.getPrice());

	}

}
