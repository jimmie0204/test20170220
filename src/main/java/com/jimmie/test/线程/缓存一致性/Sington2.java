package com.jimmie.test.线程.缓存一致性;

public class Sington2 {
	private  int count=0;//有了同步synchronized，加不加volatile没什么区别
	
	public Sington2(){}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public synchronized int increase() {
		count++;
		return count;
	}
	
}