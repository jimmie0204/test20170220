package com.jimmie.test.异步.调用;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * 如果调用complete造成的completablefuture
*过渡到已完成状态
 * @author Jimmie
 *
 */
public class CompleteTest {
	
    public static void main(String[] args) throws Exception {
        final 	CompletableFuture<Integer> f = CompletableFuture.supplyAsync(new Supplier<Integer>() {
			@Override
			public Integer get() {
				try {
					TimeUnit.SECONDS.sleep(3);
					System.out.println(Thread.currentThread().getName());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return 6;
			}
		});
        
        class Client extends Thread {
            CompletableFuture<Integer> f;
            Client(String threadName, CompletableFuture<Integer> f) {
                super(threadName);
                this.f = f;
            }
            @Override
            public void run() {
                try {
                    System.out.println(this.getName() + ": " + f.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
        new Client("Client1", f).start();
        new Client("Client2", f).start();
        System.out.println("waiting");
//        f.complete(100);// 手动给一个结果，一步的结果就没用意义了，因为complete已经触发了客户端（也就是等待结果的线程），有可能导致客户端会得到不期望的结果
        f.completeExceptionally(new Exception());//但是原来的任务还是会执行，只是不返回给客户端了
        System.in.read();
    }
}