package com.jimmie.test.异步.调用;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.Test;

public class GetOrJoinTest {
	
	@Test
	public void test() throws InterruptedException, ExecutionException{}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
		    int i = 1/0;
		    return 100;
		});
		future.join();
//		future.get();
	
	}
}
