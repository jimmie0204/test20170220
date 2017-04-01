package com.jimmie.test.异步;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

public class AsynTest3 {
	private static ExecutorService executor = Executors.newCachedThreadPool();
	
	public static Integer  haoshi() throws InterruptedException{
		Thread.sleep(5000);
		return 10;
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		
		
		Callable<Integer> call = new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				return haoshi();
			}
		};

		
		ListeningExecutorService listeningDecorator = MoreExecutors.listeningDecorator(executor);
		ListenableFuture<?> submit2 = listeningDecorator.submit(call);
		submit2.addListener(new Runnable() {
			
			@Override
			public void run() {
				try {
					System.out.println("自动异步返回结果"+submit2.get());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}, executor);
		
		System.out.println("zuo other things..,有结果会异步返回");
		TimeUnit.SECONDS.sleep(100);
		executor.shutdown();
	}
}
