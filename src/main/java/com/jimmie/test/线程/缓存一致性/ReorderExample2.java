package com.jimmie.test.线程.缓存一致性;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class ReorderExample2 {

	int a=0 , b= 0;
	int x=-999,y=-999;

	public void func1() {
//		a = 1; //A1
//		x = b; //A2
		x = b; //A2
		a = 1; //A1
	}

	public void func2() {
//		b = 2; //B1
//		y = a; //B2
		y = a; //B2
		b = 2; //B1
	}
	
	public void print(){
		System.out.println("x="+x+";y="+y);
		if(x==0&&y==0)
			System.out.println("chuxinale===============x=y=0================================");
	}
	
	
	public static void main(String[] args) {
		
		ReorderExample2  example = new ReorderExample2();
		CyclicBarrier barrier = new CyclicBarrier(2);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					barrier.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				example.func1();
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					barrier.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				example.func2();
			}
		}).start();
		
	}
}