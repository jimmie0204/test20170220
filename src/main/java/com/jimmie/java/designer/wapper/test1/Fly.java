package com.jimmie.java.designer.wapper.test1;

public class Fly extends Can{

	public Fly(Animal ani){
		this.ani = ani;
	}
	

	@Override
	public void bingo() {

		System.out.println("fly before");
		System.out.println("i can fly");
		System.out.println("fly after");
		super.bingo();
	}


}
