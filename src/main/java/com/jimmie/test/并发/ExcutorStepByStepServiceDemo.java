package com.jimmie.test.并发;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExcutorStepByStepServiceDemo {

	public static void main(String[] args) throws InterruptedException {
		
		final ExecutorService exc = Executors.newFixedThreadPool(10);
		
		ExecutorStepByStepService<Integer> serv = new ExecutorStepByStepService<Integer>(exc);
		
		/**
		 * 模拟瞬间产生10个任务，且每个任务执行时间不一致
		 */
		for (int i = 0; i < 10; i++)
		{
			serv.submit(new Callable<Integer>()
			{
				@Override
				public Integer call() throws Exception
				{
					int ran = new Random().nextInt(1000);
					Thread.sleep(ran);
					System.out.println(Thread.currentThread().getName()
							+ " 休息了 " + ran);
					return ran;
				}
				
			});
			
			Thread.sleep(200);//为了按顺序提交，方便验证
		}
		
		/**
		 * 立即输出结果
		 */
		System.out.println("=========");
		for (int i = 0; i < 10; i++)
		{
			try
			{	
				//谁最先提交谁先返回
				Future<Integer> f = serv.take(i);
//				System.out.println(f);
				System.out.println(f.get());
			} catch (Exception e)
			{
				e.printStackTrace();
			} 
		}

		exc.shutdown();

	}

}
