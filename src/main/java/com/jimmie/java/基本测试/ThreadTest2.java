package com.jimmie.java.基本测试;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ThreadTest2{
	public static void main(String[] args) {
		ThreadFactory defaultThreadFactory = Executors.defaultThreadFactory();
		defaultThreadFactory.newThread(new Worker()).start();
		defaultThreadFactory.newThread(new Worker()).start();
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