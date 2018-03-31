package com.jimmie.java.基本测试.线程池;

import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolTest2 {

	AtomicInteger count = new AtomicInteger();

	public static void main(String[] args) {
	}

	private ExecutorService executor = new ThreadPoolExecutor(
			Runtime.getRuntime().availableProcessors(),
			Runtime.getRuntime().availableProcessors() * 2,
			30, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(2000),
			new ThreadPoolExecutor.CallerRunsPolicy());

	@Test
	public void test1(){
		Future<Object> result = executor.submit(new Callable<Object>() {

			@Override
			public Object call() throws Exception {
				int i = 1 / 0;
				return true;
			}
		});

		Object o = null;
		try {
			o = result.get();
			System.out.println(o.toString());
			System.in.read();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}


}
