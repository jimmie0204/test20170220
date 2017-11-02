package com.jimmie.java.基本测试;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

	public static void main(String[] args) {
		ExecutorService ex = Executors.newFixedThreadPool(1);
		ex.submit(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("task1==="+Thread.currentThread().getId()+"==="+Thread.currentThread().hashCode()+"==="+Thread.currentThread().getName());
				
			}
		});

		ex.submit(()->{
			System.out.println("task2==="+Thread.currentThread().getId()+"==="+Thread.currentThread().hashCode()+"==="+Thread.currentThread().getName());
		});
	}

}
