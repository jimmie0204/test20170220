package com.jimmie.test.异步.调用;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

public class ResultTest {

	private static Random rand = new Random();
	
	
	@Test
	public void testEx(){
		CompletableFuture<Integer> fu = CompletableFuture.supplyAsync(new Supplier<Integer>() {

			@Override
			public Integer get() {
				  int i = 1/0;
				  return 100;
			}
		});
		
		CompletableFuture<Integer> exceptionally = fu.exceptionally(new Function<Throwable, Integer>() {

			@Override
			public Integer apply(Throwable t) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		
	}
	
	
    static int getMoreData() {
    	 long t = System.currentTimeMillis();
        System.out.println("begin to start compute");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end to start compute. passed " + (System.currentTimeMillis() - t)/1000 + " seconds");
        return rand.nextInt(1000);
    }
    public static void main(String[] args) throws Exception {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(ResultTest::getMoreData);
        System.out.println("正在异步执行。。。"+future);
        CompletableFuture<Integer> f = future.whenComplete((v, e) -> {
            System.out.println(v);
            System.out.println(e);
        });
        System.out.println("2。。。"+f);
        System.out.println(f.get());
        System.out.println("3。。。");
        System.in.read();
    }
}
