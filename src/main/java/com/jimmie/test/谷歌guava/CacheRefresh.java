package com.jimmie.test.谷歌guava;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;  

/** 
* 刷新和回收不太一样。正如LoadingCache.refresh(K)所声明，刷新表示为键加载新值，这个过程可以是异步的。在刷新操作进行时， 
* 缓存仍然可以向其他线程返回旧值，而不像回收操作，读缓存的线程必须等待新值加载完成。 
*  
* 如果刷新过程抛出异常，缓存将保留旧值，而异常会在记录到日志后被丢弃 
*  
* @author lenovo 
* 
*/  
public class CacheRefresh  
{  

  static int ixs = 0;  

  public static void main(String[] args) throws InterruptedException,  
          ExecutionException  
  {  

      LoadingCache<String, String> graphs = CacheBuilder.newBuilder()  
              .maximumSize(1000).refreshAfterWrite(1, TimeUnit.SECONDS)  
              .build(new CacheLoader<String, String>()  
              {  
                  @Override  
                  public ListenableFuture<String> reload(final String key,  
                          String oldValue) throws Exception  
                  {  
                      System.out.println("oldValue:" + oldValue);  
                      ixs++;  
                      if (key.equals("keyx")) {  
                          return Futures.immediateFuture("new Values_" + ixs);  
                      } else {  

                          ListenableFutureTask<String> taks = ListenableFutureTask  
                                  .create(new Callable<String>()  
                                  {  
                                      @Override  
                                      public String call() throws Exception  
                                      {  
                                          return key + " xxxxxx_" + ixs;  
                                      }  
                                  });  
                          Executor executor = Executors.newFixedThreadPool(10);
                          executor.execute(taks);  
                          return taks;  
                      }  

                  }  

                  @Override  
                  public String load(String arg0) throws Exception  
                  {  
                      return "get-if-absent-compute_" + ixs;  
                  }  

              });  

      String resultVal = null;  

      resultVal = graphs.get("key");  

      System.out.println(resultVal);  
      Thread.sleep(2000);  
      resultVal = graphs.get("key");  
      System.out.println(resultVal);  
      /* Thread.sleep(2000);  
      resultVal = graphs.get("key");  
      System.out.println(resultVal);  
      Thread.sleep(5000);  
      resultVal = graphs.get("key");  
      System.out.println(resultVal);  
      
      Cache<String, String> cache = CacheBuilder.newBuilder().maximumSize(1000).build();  
      String zz = cache.get("code", new Callable<String>() {  
          public String call() {  
              String strProValue="begin "+"code"+"!";                
              return strProValue;
          }  
      });  
System.out.println("value : " + zz); //value : begin code!
*/  }  
}  