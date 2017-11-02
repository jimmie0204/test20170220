package com.jimmie.java.designer.prototype;

public class BMWCar extends Car{

	public BMWCar(){
		System.out.println("BMWCar create...");
	}


	@Override
	public Car fuzhi() {
		// TODO Auto-generated method stub
		try {
			return (Car) this.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
