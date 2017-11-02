package com.jimmie.java.designer.wapper.test4;

public class Zeus implements Hero{

	private Hero hero;
	
	public Zeus(Hero hero){
		this.hero = hero;
	}
	@Override
	public void fire() {
		System.out.println("i'm zeus");
		hero.fire();
	}

}
