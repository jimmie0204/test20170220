package com.jimmie.java.designer.wapper.test1;

public class Swim extends Can{

	public Swim(Animal ani){
		this.ani = ani;
	}
	

	@Override
	public void bingo() {
		System.out.println("swim before");
		System.out.println("i can swim");
		System.out.println("swim after");
		super.bingo();
	}
}
