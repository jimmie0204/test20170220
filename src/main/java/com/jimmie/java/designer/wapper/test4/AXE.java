package com.jimmie.java.designer.wapper.test4;

import com.jimmie.java.基本测试.Student;

public class AXE extends Zeus{

	private Student s;
	
	public AXE(Hero hero){
		super(hero);
	}
	public AXE(Hero hero,Student s) {
		super(hero);
		this.s = s;
	}
	
	public void fire(){
		System.out.println("i'm axe");
		super.fire();
	}

}
