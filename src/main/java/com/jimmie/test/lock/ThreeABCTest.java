package com.jimmie.test.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreeABCTest{

	private ReentrantLock lock = new ReentrantLock();
	Condition a = lock.newCondition();
	Condition b = lock.newCondition();
	Condition c = lock.newCondition();
	
	String ch = "A";
	protected AtomicInteger count = new AtomicInteger(1);
		
	public void printA(){
		System.out.println("A尝试获取锁ing。。。");
		lock.lock();
		System.out.println("A获取锁，打印A ing。。。");
		try {

			if(ch=="A"&&count.intValue()<4){
				System.out.println("A");
				ch = "B";
				b.signal();
			}else
				a.await();
			

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			lock.unlock();
		}

	}
	public void printB(){
		System.out.println("B尝试获取锁ing。。。");
		lock.lock();
		System.out.println("B获取锁，打印B ing。。。");
		lock.lock();
		try {
			if(ch=="B"&&count.intValue()<4){
				System.out.println("B");
				ch="C";
				c.signal();
			}else
				b.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			lock.unlock();
		}

	}
	public void printC(){
		System.out.println("C尝试获取锁ing。。。");
		lock.lock();
		System.out.println("C获取锁，打印C ing。。。");
		try {
			if(ch=="C"&&count.intValue()<4){
				System.out.println("C");
				System.out.println("这是第"+count.intValue()+"遍");
				count.getAndIncrement();
				ch="A";
				a.signal();
			}else
				c.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			lock.unlock();
		}

	}
	public static void main(String[] args) {
		ThreeABCTest t = new ThreeABCTest();
		
		A oa = new A(t);
		B ob = new B(t);
		C oc = new C(t);
		oa.start();
		ob.start();
		oc.start();
		
	}

	
}

class A extends Thread{
	ThreeABCTest t;
	public A(ThreeABCTest t) {
		this.t = t;
	}
	@Override
	public void run() {
		while(true){
//			System.out.println(t.count.get());
			if(t.count.intValue()>=4)
				break;
			t.printA();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
class B extends Thread{
	ThreeABCTest t;
	public B(ThreeABCTest t) {
		this.t = t;
	}
	@Override
	public void run() {
		while(true){
//			System.out.println(t.count.get());
			if(t.count.intValue()>=4)
				break;
			t.printB();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class C extends Thread{
	ThreeABCTest t;
	public C(ThreeABCTest t) {
		this.t = t;
	}
	@Override
	public void run() {
		while(true){
//			System.out.println(t.count.get());
			if(t.count.intValue()>=4)
				break;
			t.printC();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}