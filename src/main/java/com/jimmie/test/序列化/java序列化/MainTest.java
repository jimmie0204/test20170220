package com.jimmie.test.序列化.java序列化;

public class MainTest {

	public static void main(String[] args) {
		Car car = new Car("Benz",5);
		byte[] t = new JavaSerializer().serialize(car);

		System.out.println(t.toString());
		
/*		Class clazz = Car.class;
		clazz.*/
	}

}
