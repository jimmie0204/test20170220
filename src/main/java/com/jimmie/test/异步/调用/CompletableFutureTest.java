package com.jimmie.test.异步.调用;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

import scala.inline;
import scala.collection.generic.BitOperations.Int;

/**
 * 因此，你可以根据方法的参数的类型来加速你的记忆。
 * Runnable类型的参数会忽略计算的结果，
 * Consumer是纯消费计算结果，
 * BiConsumer会组合另外一个CompletionStage纯消费，即加上异常处理
 * Function会对计算结果做转换，
 * BiFunction会组合另外一个CompletionStage的计算结果做转换，即加上异常处理。
 * @author Jimmie
 *
 */
public class CompletableFutureTest {

	@Test
	public void test() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(5);

		Future<String> result = executor.submit(() -> {
			TimeUnit.SECONDS.sleep(3);
			return "hello";
		});
		System.out.println(result.get());
		System.out.println("主线程over");
	}

	@Test
	public void test2() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(5);

		CompletableFuture<String> resultCompletableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
			@Override
			public String get() {
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "hello";
			}
		}, executor);
		System.out.println(resultCompletableFuture.get());
		System.out.println("主线程over");
	}

	// CompletableFuture注册类似一个回调函数去处理结果
	@Test
	public void test3_1_thenAccept() throws InterruptedException, ExecutionException {

		ExecutorService executor = Executors.newFixedThreadPool(5);

		CompletableFuture<String> resultCompletableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
			@Override
			public String get() {
				try {
					TimeUnit.SECONDS.sleep(3);
					System.out.println(Thread.currentThread().getName());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "hello";
			}
		}, executor);
		
		//接受正常结果或者失败
		//方式一
		
/*		CompletableFuture<Void> exceptionally = resultCompletableFuture.thenAccept(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
				System.out.println(Thread.currentThread().getName());
			}
		}).exceptionally(new Function<Throwable, Void>() {

			@Override
			public Void apply(Throwable t) {
				System.out.println(t.getMessage());
				return null;
			}
		});
		*/
		
		//方式二
		
		/*CompletableFuture<Void> thenAccept = resultCompletableFuture.exceptionally(new Function<Throwable, String>() {
			@Override
			public String apply(Throwable t) {
				System.out.println(t.getMessage());
				return t.getMessage();
			}
		}).thenAccept(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println("accept--" + t);
				System.out.println("accept--" + Thread.currentThread().getName());
			}
		});*/
		
		//方式三
		CompletableFuture<Void> thenAccept = resultCompletableFuture.thenAccept(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
				System.out.println(Thread.currentThread().getName());
			}
		});
		
		CompletableFuture<String> exceptionally2 = resultCompletableFuture.exceptionally(new Function<Throwable, String>() {

			@Override
			public String apply(Throwable t) {
				System.out.println(t.getMessage());
				return t.getMessage();
			}
		});
		
		/**
		 * 如果原始的CompletableFuture正常计算完后，这个新的CompletableFuture也计算完成，它的值和原始的CompletableFuture的计算的值相同
		 */
		exceptionally2.thenAccept(new Consumer<String>() {//被动触发，也可以在apply中同步执行其实

			@Override
			public void accept(String t) {
				System.out.println("jieshoudaode1 异常："+t);
			}
		});
		
		//==========================

		System.out.println("主线程over");
//		resultCompletableFuture.completeExceptionally(new Exception("error"));
		TimeUnit.SECONDS.sleep(300);
	}

	/**
	 *thenRun当计算完成的时候会执行一个Runnable,与thenAccept不同，Runnable并不使用CompletableFuture计算的结果，
	 *因此先前的CompletableFuture计算的结果被忽略了,这个方法返回CompletableFuture<Void>类型的对象。
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	@Test
	public void test3_2_thenRun() throws InterruptedException, ExecutionException {

		ExecutorService executor = Executors.newFixedThreadPool(5);

		CompletableFuture<String> resultCompletableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
			@Override
			public String get() {
				try {
					TimeUnit.SECONDS.sleep(3);
					System.out.println(Thread.currentThread().getName());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "hello";
			}
		}, executor);

		 CompletableFuture<Void> thenRun = resultCompletableFuture.thenRun(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("父future已完成，我正在执行runnable接口方法");
				
			}
		});

		System.out.println("主线程over");
//		resultCompletableFuture.completeExceptionally(new Exception("error"));
		TimeUnit.SECONDS.sleep(300);
	}
	
	/**
	 * whenComplete 完成时的回调处理，正常结果也异常都能处理，不过得自己判断是正常还是异常
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	@Test
	public void test3_3_whenComplete() throws InterruptedException, ExecutionException {

		ExecutorService executor = Executors.newFixedThreadPool(5);

		CompletableFuture<String> resultCompletableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
			@Override
			public String get() {
				try {
					TimeUnit.SECONDS.sleep(3);
					System.out.println(Thread.currentThread().getName());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "hello";
			}
		}, executor);

		CompletableFuture<String> whenComplete = resultCompletableFuture.whenComplete(new BiConsumer<String,Throwable>() {

			@Override
			public void accept(String t, Throwable u) {
				System.out.println(t);
				System.out.println(Thread.currentThread().getName());
				System.out.println(u);
				
			}
		});

		System.out.println("主线程over");
//		resultCompletableFuture.completeExceptionally(new Exception("error"));
		TimeUnit.SECONDS.sleep(300);
	}

	
	/**
	 * exceptionally方法返回一个新的CompletableFuture，当原始的CompletableFuture抛出异常的时候，就会触发这个CompletableFuture的计算，调用function计算值
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	@Test
	public void test4_exceptionally() throws InterruptedException, ExecutionException {

		ExecutorService executor = Executors.newFixedThreadPool(5);

		CompletableFuture<String> resultCompletableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
			@Override
			public String get() {
				try {
					TimeUnit.SECONDS.sleep(3);
					System.out.println(Thread.currentThread().getName());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "hello";
			}
		}, executor);

		
		CompletableFuture<String> exceptionally = resultCompletableFuture.exceptionally(new Function<Throwable, String>() {

			@Override
			public String apply(Throwable t) {
				System.out.println("cao ,yichagnle1");
				return "ex一场了，已被出力";
			}
		});
		
		exceptionally.thenAccept(new Consumer<String>() {//被动出发了

			@Override
			public void accept(String t) {
				System.out.println("jieshoudaode1 异常："+t);
				
			}
		});

		System.out.println("主线程over");
		resultCompletableFuture.completeExceptionally(new Exception("error"));
		TimeUnit.SECONDS.sleep(300);
	}
	
	/**
	 * thenApply功能是当原来的CompletableFuture计算完后，将结果传递给函数fn
	 * ，将fn的结果作为新的CompletableFuture计算结果。因此它的功能相当于将CompletableFuture<T>转换成CompletableFuture<U>。
	 * //如果原future有异常，则不执行thenApply
	 * @throws InterruptedException
	 * @throws ExecutionException
	 * @throws IOException 
	 */
	@Test
	public void test5_thenApply() throws InterruptedException, ExecutionException, IOException {

		ExecutorService executor = Executors.newFixedThreadPool(5);

		CompletableFuture<String> resultCompletableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
			@Override
			public String get() {
				try {
					TimeUnit.SECONDS.sleep(3);
					System.out.println(Thread.currentThread().getName());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "hello";
			}
		}, executor);
		
		CompletableFuture<Integer> thenApply = resultCompletableFuture.thenApply(new Function<String, Integer>() {

			@Override
			public Integer apply(String t) {
				System.out.println("父future结果已经收到==="+t);
				System.out.println(Thread.currentThread().getName());
				return Integer.valueOf(t.length());
			}
		});
		
		resultCompletableFuture.thenAcceptAsync(new Consumer<String>() {

			@Override
			public void accept(String t) {
				try {
					System.out.println("我是父future执行完触发的。。");
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		resultCompletableFuture.exceptionally(new Function<Throwable, String>() {

			@Override
			public String apply(Throwable t) {
				System.out.println("我是父future抛出的异常处理方法。。");
				return null;
			}
		});
		

		System.out.println("主线程over");
		resultCompletableFuture.completeExceptionally(new Exception("error"));
		System.in.read();
	}

	/**
	 * handle与thenApply方法的区别在于handle方法会处理正常计算值和异常，
	 * 因此它可以屏蔽异常，避免异常继续抛出。而thenApply方法只是用来处理正常值，因此一旦有异常就会抛出
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	@Test
	public void test6_handle() throws InterruptedException, ExecutionException {

		ExecutorService executor = Executors.newFixedThreadPool(5);

		CompletableFuture<String> resultCompletableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
			@Override
			public String get() {
				try {
					TimeUnit.SECONDS.sleep(3);
					System.out.println("父future结束，已返回结果");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "hello";
			}
		}, executor);
		
		CompletableFuture<Integer> thenApply = resultCompletableFuture.thenApply(new Function<String, Integer>() {

			@Override
			public Integer apply(String t) {
				System.out.println("thenApply");
				System.out.println(t);
				return Integer.valueOf(t.length());
			}
		});
		
		
		CompletableFuture<Integer> handle = resultCompletableFuture.handle(new BiFunction<String, Throwable, Integer>() {
			@Override
			public Integer apply(String t, Throwable u) {
				if (t != null) {
					System.out.println("handler");
					return t.length();
				} else {
					System.out.println("handler，异常信息为"+u);
					return -1;
				}
			}
		});
		
		System.out.println("主线程over");
		resultCompletableFuture.completeExceptionally(new Exception("error"));
		TimeUnit.SECONDS.sleep(300);
	}
	
	/**
	 * 当两个CompletionStage都正常完成计算的时候，就会执行提供的action，它用来组合另外一个异步的结果
	 * @throws InterruptedException 
	 */
	@Test
	public void test7_thenAcceptBoth() throws InterruptedException{
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("第一个future完成");
		    return 100;
		});
		
		CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(new Supplier<Integer>() {

			@Override
			public Integer get() {
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("第二个future完成");
				return 10;
			}
		});
		
		CompletableFuture<Void> f =  future.thenAcceptBoth(future2, (x, y) -> System.out.println(x * y));
		System.out.println("主线程over");
		future.completeExceptionally(new Exception("error"));//会阻断后面需要父future结果的future运行
		TimeUnit.SECONDS.sleep(300);
		
	}
	
	/**
	 * 从功能上来讲,thenCombine的功能更类似thenAcceptBoth，只不过thenAcceptBoth是纯消费，它的函数参数没有返回值，而thenCombine的函数参数fn有返回值
	 * @throws InterruptedException 
	 */
	@Test
	public void test8_thenCombine() throws InterruptedException{
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("第一个future完成");
		    return 100;
		});
		
		CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(new Supplier<Integer>() {

			@Override
			public Integer get() {
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("第二个future完成");
				return 10;
			}
		});
		
		CompletableFuture<Integer> f = future.thenCombine(future2, (x, y) -> {
			System.out.println(x * y);
			return x * y;
		});
		
		System.out.println("主线程over");
//		future.completeExceptionally(new Exception("error"));//会阻断后面需要父future结果的future运行
		TimeUnit.SECONDS.sleep(300);
		
	}

	/**
	 * thenCompose需要父future的值，等父future完成以后，再执行第二个future，这他妈不就是thenApply吗
	 * @throws InterruptedException 
	 */
	@Test
	public void test8_thenCompose() throws InterruptedException{
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("第一个future完成");
		    return 100;
		});
		
		
		
		CompletableFuture<String> f = future.thenCompose(new Function<Integer, CompletionStage<String>>() {

			@Override
			public CompletionStage<String> apply(Integer t) {
				
				return  CompletableFuture.supplyAsync(new Supplier<String>() {

						@Override
						public String get() {
							try {
								TimeUnit.SECONDS.sleep(2);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("第二个future完成");
							return t+"===="+10;
						}
					});
			}
			
		});
		
		System.out.println("主线程over");
//		future.completeExceptionally(new Exception("error"));//会阻断后面需要父future结果的future运行
		TimeUnit.SECONDS.sleep(300);
		
	}
	
	public static void main(String[] args) {
		
		
	}
}
