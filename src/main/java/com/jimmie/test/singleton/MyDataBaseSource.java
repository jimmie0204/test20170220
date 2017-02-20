package com.jimmie.test.singleton;


public enum MyDataBaseSource {
    DATASOURCE;

    private MyDataBaseSource() {
    	System.out.println("create...");
    }

    public MyDataBaseSource getConnection() {
    	 return DATASOURCE;
    }
    
    public void print(){
    	System.out.println("dayin");
    }
    
    public void print2(){
    	System.out.println("dayin2");
    }


}