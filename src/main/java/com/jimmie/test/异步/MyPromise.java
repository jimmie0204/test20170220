package com.jimmie.test.异步;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/**
 * 目标：在根据任务的不同状态阶段触发不同的回调，异步完成
 * 
 * java中线城池submit返回的是futrueTask（new出来的不对外，除非像ExecutorCompletionService这样扩展：组合了executor，重新实现了FutureTask），根据不同状态会回调futrueTask中的done方法完成回调，
 * 
 * 谷歌是自己实现了一套executor、future
 * 
 * netty
 * 
 * @author Jimmie
 *
 * @param <V>
 */
public class MyPromise<V> extends FutureTask<V>{

	private CallBack callback;
	
	public MyPromise(Callable<V> callable,CallBack callback) {
		super(callable);
		this.callback = callback;
	}
	
	@Override
	public void done(){
		super.done();
		callback.cancel();
	}

}
