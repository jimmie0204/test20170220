package com.jimmie.test.异步.调用;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class CompletableFutureTest2 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(5);  
		
		CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> { 
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    return "zero";  
		}, executor);  
		  
		CompletableFuture<Integer> f2 = f1.thenApply(new Function<String, Integer>() {  
		  
		    @Override  
		    public Integer apply(String t) {  
		        System.out.println(t);  
		        return Integer.valueOf(t.length());  
		    }  
		});  
		
//		f1.thenAccept(action)
		  
		CompletableFuture<Double> f3 = f2.thenApply(r -> r * 2.0);  
		System.out.println(f3.get());  
	}
}
