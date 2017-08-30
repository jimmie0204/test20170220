package com.jimmie.test.线程.阻塞;

import java.util.concurrent.CyclicBarrier;

public class WaitTest {
	
	static class Inner{
		public synchronized void search() throws Exception{
			System.out.println(Thread.currentThread().getName()+"==进入search同步块");
			Thread.sleep(1000);
			
			wait();
			System.out.println(Thread.currentThread().getName()+"==被唤醒");
		}
		
		public synchronized void escape() throws Exception{
			System.out.println(Thread.currentThread().getName()+"==进入escape同步块");
			notify();//只唤醒某一个
//			notifyAll();//唤醒所有
		}
	}
	

	public static void main(String[] args) throws Exception{
		Inner inn = new Inner();
		CyclicBarrier barrier = new CyclicBarrier(3);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					barrier.await();
					inn.search();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();;
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					barrier.await();
					inn.search();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();;
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					barrier.await();
					Thread.sleep(3000);
					inn.escape();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();;
		
		System.in.read();
		
	}
}
