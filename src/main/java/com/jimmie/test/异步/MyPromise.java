package com.jimmie.test.异步;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * 目标：在根据任务的不同状态阶段触发不同的回调，异步完成
 * 
 * java中线城池submit返回的是futrueTask（new出来的不对外，除非像ExecutorCompletionService这样扩展：组合了executor，重新实现了FutureTask），
 * 根据不同状态会回调futrueTask中的done方法完成回调，futrueTask通过内部类Syn（继承了AQS，持有一个value）完成了同步
 * 
 * 谷歌是自己实现了一套executor、future，同java
 * 
 * netty DefaultPromise(持有一个value)，相当于futrueTask，不同的是它通过wait/notify完成同步，并且是手动设置异步执行的结果
 * 
 * @author Jimmie
 * @param <V>
 *
 * @param <V>
 */
public class MyPromise<V>{

	private ExecutorService executor;
	
	private Future<V> future;
	
	public MyPromise(Future<V> future,ExecutorService executor) {
		this.future = checkNotNull(future, "future 不能为空");
		if(executor==null)
			this.executor = Executors.newFixedThreadPool(5);
		else
			this.executor = executor;
	}
	
	  public  <T> T checkNotNull(T reference,  String errorMessage) {
		    if (reference == null) {
		      throw new NullPointerException(String.valueOf(errorMessage));
		    }
		    return reference;
	  }
	  
	  public void cancel(){
		  future.cancel(true);
	  }
	
	  public void addListenter(CallBack<V> callback){
		  Runnable asn = new Runnable() {
				
			@Override
			 public void run() {
				final V value;
				if(callback!=null){
					
					if(future.isCancelled()){
						System.out.println("out-Cancel==========");
		            	 callback.onCancel();
		             } else {
		            	 try {
		            		 value = future.get();
				            } catch (ExecutionException e) {
				            	e.printStackTrace();
				            	System.out.println("ExecutionException==========");
				            	callback.onFailure(e.getCause());
					              return;
				            } catch (InterruptedException e) {
				            	e.printStackTrace();
				            	System.out.println("InterruptedException==========");
				            	callback.onFailure(e.getCause());
					              return;
							}catch (CancellationException e) {
				            	e.printStackTrace();
				            	System.out.println("in-CancellationException==========");
				            	callback.onCancel();
					              return;
							}catch (RuntimeException e) {
								e.printStackTrace();
								System.out.println("RuntimeException==========");
				              callback.onFailure(e);
				              return;
				            } catch (Error e) {
				            	e.printStackTrace();
				            	System.out.println("Error==========");
				              callback.onFailure(e);
				              return;
				            }
				            callback.onSuccess(value);
		             }
					
				}else{
					try {
						value = future.get();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (ExecutionException e) {
						e.printStackTrace();
					}
				}
	            
	          }
		};
		
		executor.execute(asn);
	  } 
	  
}
