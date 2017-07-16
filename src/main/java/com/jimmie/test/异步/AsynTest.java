package com.jimmie.test.异步;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class AsynTest {
	
	private static ExecutorService executor = Executors.newCachedThreadPool();
	public static Integer  haoshi() throws InterruptedException{
		Thread.sleep(5000);
		return 10;
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		FutureTask<Integer> future = new FutureTask<Integer>(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				return haoshi();
			}
		});
		
		
		Callable<Integer> call = new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				return haoshi();
			}
		};
		
		Future<?> submit = executor.submit(future);
		
		Future<?> submit2 = executor.submit(call);
		
		System.out.println("zuo other things..");
		
		System.out.println(future);
		System.out.println(submit);
		System.out.println(submit2);
		
/*		System.out.println(future.get());
		System.out.println(submit.get());
		System.out.println(submit2.get());*/
		try {
			System.out.println(future.get(1,TimeUnit.SECONDS));
			System.out.println(submit.get());
			System.out.println(submit2.get(1,TimeUnit.SECONDS));
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		executor.shutdown();
	}
}
