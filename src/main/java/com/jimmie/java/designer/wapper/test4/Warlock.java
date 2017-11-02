package com.jimmie.java.designer.wapper.test4;

public class Warlock implements Hero {

	private Hero hero;
	
	public Warlock(Hero hero){
		this.hero = hero;
	}
	@Override
	public void fire() {
		System.out.println("i'm warlock");
		hero.fire();

	}

}
