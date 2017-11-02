package com.jimmie.java.designer.wapper.test3;

public class ZuoChe extends Operation{

	public ZuoChe(Person person){
		this.person = person;
	}
	@Override
	public void dosth() {
		person.dosth();
		System.out.println("坐车");
		
	}

}
