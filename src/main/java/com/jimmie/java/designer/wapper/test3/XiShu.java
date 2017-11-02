package com.jimmie.java.designer.wapper.test3;

public class XiShu extends Operation{

	public XiShu(Person person){
		this.person = person;
	}
	@Override
	public void dosth() {
		person.dosth();
		System.out.println("洗漱  ");
		
	}

}
