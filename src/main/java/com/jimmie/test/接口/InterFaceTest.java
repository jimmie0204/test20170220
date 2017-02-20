package com.jimmie.test.接口;

public class InterFaceTest {

	public static void main(String[] args) throws Exception {
		InterManager manager = new InterManager();
		manager.reset();
		System.out.println(manager.getTool());
		System.out.println(manager.getTool());
		manager.reset();
		System.out.println(manager.getTool());
		System.out.println(manager.getTool());
	}
}
