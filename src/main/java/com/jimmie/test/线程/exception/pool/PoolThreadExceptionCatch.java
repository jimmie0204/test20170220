package com.jimmie.test.线程.exception.pool;

import com.jimmie.test.线程.exception.Task;
import com.jimmie.test.线程.exception.TaskCall;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * 线程池捕获异常
 * @author Administrator
 *
 */
public class PoolThreadExceptionCatch {
	
	public static void main(String[] args) {
		
		  ExecutorService executorService = Executors.newCachedThreadPool(new MyThreadFactory());
	      executorService.execute(new Task());
	     
	      
	      Future<Integer> future = executorService.submit(new TaskCall());

	      try {
			 future.get();
		} catch (InterruptedException | ExecutionException e) {
			System.out.println("我是由 future抛出的异常捕获");
		}
	      
	      executorService.shutdownNow();
	}

}
