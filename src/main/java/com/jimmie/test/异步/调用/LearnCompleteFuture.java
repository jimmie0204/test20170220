package com.jimmie.test.异步.调用;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;  
  
public class LearnCompleteFuture {  
      
    private static Random random = new Random();  
  
    public static void main(String[] args) throws InterruptedException, ExecutionException {  
        useFuture();  
          
        TimeUnit.SECONDS.sleep(5);  
        System.out.println("==========================");  
          
//        useCompletableFuture();  
    }  
  
    private static void useFuture() throws InterruptedException, ExecutionException {  
        System.out.println("Future");  
        ExecutorService exector = Executors.newFixedThreadPool(3);  
        Future<Void> futureA = exector.submit(() -> work("A1"));  
        Future<Void> futureB = exector.submit(() -> work("B1"));  
        while (true) {  
            try {  
            	System.out.println("阻塞A1，等待结果");
                futureA.get(1, TimeUnit.SECONDS);  //设置时间内获取不到结果会抛异常继续往下走
                break;  
            } catch (TimeoutException e) {  
            }  
            try {  
            	System.out.println("阻塞B1，等待结果");
                futureB.get(1, TimeUnit.SECONDS);  
                break;  
            } catch (TimeoutException e) {  
            }  
        }  
        exector.submit(() -> work("C1")).get();  
        exector.shutdown();  
    }  
      
    private static void useCompletableFuture() throws InterruptedException, ExecutionException {  
        System.out.println("CompletableFuture");  
        CompletableFuture<Void> futureA = CompletableFuture.runAsync(() -> work("A2"));  
        CompletableFuture<Void> futureB = CompletableFuture.runAsync(() -> work("B2"));  
        futureA.runAfterEither(futureB, () -> work("C2")).get();  
    }  
  
    public static Void work(String name) {  
    	long begin = System.currentTimeMillis();
        System.out.println(name + " starts at " + LocalTime.now());  
        System.out.println(name+"在in thread："+Thread.currentThread().getName());
        try {  
            TimeUnit.SECONDS.sleep(random.nextInt(5));  
        } catch (InterruptedException e) {  
        }  
        System.out.println(name + " ends at " + LocalTime.now());  
        System.out.println(name + " 用时： " + (System.currentTimeMillis()-begin));  
        return null;  
    }  
}  