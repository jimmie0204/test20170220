package com.jimmie.test.谷歌guava;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

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
	
	@Test
	public void test4() throws ExecutionException, InterruptedException{
		LoadingCache<String, String> cache = CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.SECONDS).build(new CacheLoader<String, String>(){

			@Override
			public String load(String key) throws Exception {
				// TODO Auto-generated method stub
				return "hello "+key+";";
			}
			
		});

		cache.put("jimmie", "sdsdsd");
		
		System.out.println(cache.get("jimmie"));;
		Thread.sleep(6000);
		System.out.println(cache.get("jimmie"));;
		System.out.println(cache.apply("mryx"));;
		System.out.println(cache.get("mryx"));;
		
	}
	
}
