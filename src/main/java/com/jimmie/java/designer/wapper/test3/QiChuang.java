package com.jimmie.java.designer.wapper.test3;

public class QiChuang extends Operation{

	public QiChuang(Person person){
		this.person = person;
	}
	@Override
	public void dosth() {
		person.dosth();
		System.out.println("起床   ");
		
	}

}
