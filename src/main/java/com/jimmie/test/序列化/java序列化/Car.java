package com.jimmie.test.序列化.java序列化;

import java.io.Serializable;

public class Car implements Serializable{  
	  /**
	 * 
	 */
	private static final long serialVersionUID = 92838166562429968L;
	private  String  make;  
	  private  int year;  
	  public Car(){
	  }
	  public Car(String  make,int year){
		  this.make = make;
		  this.year = year;
	  }
	    public String getMake() {  
	        return make;  
	    }  
	    public void setMake(String make) {  
	        this.make = make;  
	    }  
	    public int getYear() {  
	        return year;  
	    }  
	    public void setYear(int year) {  
	        this.year = year;  
	    }  
	    
	    public static void main(String[] args) {
			new Car();
			new Car();
		}
	        
	}