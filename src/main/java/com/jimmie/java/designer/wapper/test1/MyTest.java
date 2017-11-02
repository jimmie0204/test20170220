package com.jimmie.java.designer.wapper.test1;

public class MyTest {

	public static void main(String[] args) {
		Animal fish = new Fish();
		
		fish = new Fly(new Swim(new Fish()));
//		Swim fish = new Swim(new Fly(new Swim(new Fish())));
		
		fish.bingo();

	}

}
