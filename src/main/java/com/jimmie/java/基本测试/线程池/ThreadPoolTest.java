package com.jimmie.java.基本测试.线程池;

import com.jimmie.java.基本测试.线程池.ForkJoinDemo;
import org.junit.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolTest {

	AtomicInteger count = new AtomicInteger();

	public static void main(String[] args) {
		ExecutorService ex = Executors.newFixedThreadPool(1);
		ex.submit(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("task1==="+Thread.currentThread().getId()+"==="+Thread.currentThread().hashCode()+"==="+Thread.currentThread().getName());
				
			}
		});

		ex.submit(()->{
			System.out.println("task2==="+Thread.currentThread().getId()+"==="+Thread.currentThread().hashCode()+"==="+Thread.currentThread().getName());
		});
	}

	@org.junit.Test
	public void test1(){
		ForkJoinPool pool = new ForkJoinPool();

		Integer[] array = {100,400,200,90,80,300,600,10,20,-10,30,2000,1000};

		MessTask task = new MessTask(array);

		pool.execute(task);

		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	class MessTask extends RecursiveAction{

		private int threshold = 2;

		private Integer[] bits;

		public MessTask(Integer[] bits) {
			this.bits = bits;
		}

		@Override
		protected void compute() {
			System.out.println("current thread==="+Thread.currentThread().hashCode()+"==="+count.get());
			if(bits.length>=threshold){
				System.out.println("开始切分任务==="+count.incrementAndGet());
				Integer[] bits1 = Arrays.copyOfRange(bits,0,bits.length/2);
				Integer[] bits2 = Arrays.copyOfRange(bits,bits.length/2,bits.length);
				MessTask mt1 = new MessTask(bits1);
				MessTask mt2 = new MessTask(bits2);

				invokeAll(mt1,mt2);
//				mt1.fork();
//				mt2.fork();
//				mt1.join();
//				mt2.join();

			}else{
				if(bits.length==1)
					System.out.println("result=========="+Thread.currentThread().hashCode()+"==="+printA(bits));
			}

		}

		public String printA(Integer[] array){

			StringBuffer buff = new StringBuffer();
			for(Integer t:array)
				buff.append(t+"==");
			return buff.toString();
		}
	}

}
