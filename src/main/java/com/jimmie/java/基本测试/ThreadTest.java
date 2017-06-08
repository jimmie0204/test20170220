package com.jimmie.java.基本测试;

public class ThreadTest{
	public static void main(String[] args) {
		try {
			new Thread(new Worker()).start();;
		} catch (Exception e) {
			System.out.println("buhuo");//如果线程中不捕获异常，这里捕获不了
		}
		
	}
	
	static class  Worker implements Runnable{

		@Override
		public void run() {
			try {
				System.out.println("worker run...");
				int i = 1/0;
			} catch (Exception e) {
				System.out.println("线程内补货异常。。。。。。。。。。");
			}
			
		}}
}