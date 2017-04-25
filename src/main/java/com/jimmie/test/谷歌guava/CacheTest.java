package com.jimmie.test.谷歌guava;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalListeners;
import com.google.common.cache.RemovalNotification;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;

public class CacheTest {

	@Test
	public void test() throws ExecutionException{
		LoadingCache<String, String> cache = CacheBuilder.newBuilder().build(new CacheLoader<String, String>(){

			@Override
			public String load(String key) throws Exception {
				// TODO Auto-generated method stub
				return "hello "+key+";";
			}
			
		});
		
		cache.put("jimmie", "sdsdsd");
		System.out.println(cache.get("jimmie"));;
		System.out.println(cache.apply("mryx"));;
		System.out.println(cache.get("mryx"));;
		
	}
	
	@Test
	public void test2() throws ExecutionException{
		Cache<String, String> cache = CacheBuilder.newBuilder().build(); 
		cache.put("jimmie", "sdsdsd");
		System.out.println(cache.get("jimmie", new Callable<String>() {

			@Override
			public String call() throws Exception {
				
				return "mmmm u";
			}
		}));;
		
		
		System.out.println(cache.get("mryx", new Callable<String>() {

			@Override
			public String call() throws Exception {
				
				return "llll u";
			}
		}));;
		
	}
	
	@Test
	public void test3() throws ExecutionException{
		LoadingCache<String, String> cache = CacheBuilder.newBuilder().build(new CacheLoader<String, String>(){

			@Override
			public String load(String key) throws Exception {
				// TODO Auto-generated method stub
				return "hello "+key+";";
			}
			
		});

		cache.put("jimmie", "sdsdsd");
		ConcurrentMap<String, String> asMap = cache.asMap();
		asMap.put("jimmie", "change other value");//一般不用这种方式更改缓存值
		
		System.out.println(cache.get("jimmie"));;
		System.out.println(cache.apply("mryx"));;
		System.out.println(cache.get("mryx"));;
		
	}
	
	/**
	 * 过时测试，同步移除监听器测试
	 * @throws ExecutionException
	 * @throws InterruptedException
	 * @throws IOException 
	 */
	@Test
	public void test4() throws ExecutionException, InterruptedException, IOException {
		LoadingCache<String, String> cache = CacheBuilder.newBuilder().expireAfterWrite(2, TimeUnit.SECONDS)
				.removalListener(new RemovalListener<String, String>() {

					@Override
					public void onRemoval(RemovalNotification<String, String> notification) {
						System.out.println(notification.getKey()+"==="+notification.getValue()+"已被移除，因为"+notification.getCause());
						
					}
				})
				.build(new CacheLoader<String, String>() {

					@Override
					public String load(String key) throws Exception {
						System.out.println("load====="+key);
						return "hello " + key + ";";
					}

				});
		

//		cache.put("jimmie", "sdsdsd");

		System.out.println(cache.get("jimmie"));

		Thread.sleep(2000);
		System.out.println(cache.get("jimmie"));
//		Thread.sleep(3000);
		System.out.println(cache.get("jimmie"));
		System.in.read();
	}
	
	/**
	 * 过时测试，异步移除监听器测试
	 * @throws ExecutionException
	 * @throws InterruptedException
	 * @throws IOException 
	 */
	@Test
	public void test5() throws ExecutionException, InterruptedException, IOException {
		LoadingCache<String, String> cache = CacheBuilder.newBuilder().expireAfterAccess(2, TimeUnit.SECONDS)
				.removalListener(	RemovalListeners.asynchronous(new RemovalListener<String, String>() {

					@Override
					public void onRemoval(RemovalNotification<String, String> notification) {
						System.out.println(notification.getKey()+"==="+notification.getValue()+"已被移除，因为"+notification.getCause());
						
					}
				}, Executors.newSingleThreadExecutor()))
				.build(new CacheLoader<String, String>() {

					@Override
					public String load(String key) throws Exception {
						System.out.println("load====="+key);
//						TimeUnit.SECONDS.sleep(5);
						return "hello " + key + ";";
					}

				});
		

		System.out.println(cache.get("jimmie"));
		System.out.println(cache.get("jimmie"));

		Thread.sleep(2000);
		System.out.println(cache.get("jimmie"));
		Thread.sleep(3000);
		System.out.println(cache.get("jimmie"));
		System.in.read();

	}
	
	
	/**
	 * 测试reload,	//有些键不需要刷新，并且我们希望刷新是异步完成的
	 * 缓存项只有在被检索时才会真正刷新
	 * 刷新和回收不太一样。正如LoadingCache.refresh(K)所声明，刷新表示为键加载新值，这个过程可以是异步的。
	 * 在刷新操作进行时，缓存仍然可以向其他线程返回旧值，而不像回收操作，读缓存的线程必须等待新值加载完成
	 * @throws InterruptedException 
	 * @throws ExecutionException 
	 * @throws IOException 

	 */
	@Test
	public void test6() throws InterruptedException, ExecutionException, IOException{
		LoadingCache<String, Object> cache = CacheBuilder.newBuilder()
				.refreshAfterWrite(2, TimeUnit.SECONDS)
				.build(new CacheLoader<String, Object>(){

			@Override
			public Object load(String key) throws Exception {
				return "hello " + key + ";";
			}
			
		
			@Override
			public ListenableFuture<Object> reload(String key, Object oldValue){
				System.out.println("调用reload=====");
				 if (neverNeedsRefresh(key)) {
					 System.out.println("直接返回=====");
				     return Futures.immediateFuture(oldValue);
				 }else{
				     // asynchronous!
				     ListenableFutureTask<Object> task=ListenableFutureTask.create(new Callable<Object>() {
				         public Object call() {
				        	 System.out.println(key+"正在被重新加载");
				             return key+"=oldValue:"+oldValue+"=reload";
				         }

				     });
				     new Thread(task).start();
//				     Executors.newCachedThreadPool().execute(task);
				     return task;

				 }			
			}


			private boolean neverNeedsRefresh(String key) {
				return false;
			}
		});
		
//		cache.put("jimmie", "sdsdsd");
//		long begintime = System.currentTimeMillis();
		System.out.println(cache.get("jimmie"));
//		System.out.println((System.currentTimeMillis()-begintime)/1000);
		TimeUnit.SECONDS.sleep(5);
		System.out.println(cache.get("jimmie"));
		TimeUnit.SECONDS.sleep(2);
		System.out.println(cache.get("jimmie"));
//		System.out.println(cache.get("jimmie"));
		System.in.read();
		
		
	} 
	
	
}
