package com.jimmie.test.线程.end;

public class ThreadEnd {
	public static void main(String[] args) throws InterruptedException {
		ThreadA a = new ThreadA();
		a.start();
		Thread.sleep(5000);
		a.interrupt();

	}

}
