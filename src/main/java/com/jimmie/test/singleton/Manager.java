package com.jimmie.test.singleton;

public enum Manager {

	INSTANCE1("1"),INTANCE2("2");
	
	private String name;
	private static IDo ido;
	private Manager(IDo ido){
		
	}
	
	private Manager(String name){
		
	}
	public static void main(String[] args) {
		Integer i=10;
		System.out.println(i.toString());
	}
}
