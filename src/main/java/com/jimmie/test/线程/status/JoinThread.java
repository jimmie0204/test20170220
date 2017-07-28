package com.jimmie.test.线程.status;

public class JoinThread extends Thread{

	public void run(){
		System.out.println("join start====");
		try {
			Thread.sleep(10000);
			System.out.println("join finish==============");
		} catch (InterruptedException e) {
			System.out.println("join 被打断退出！！！");
		}
		
	}
	
	
	public static void main(String[] args) {
		JoinThread t = new JoinThread();
		t.start();
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				t.interrupt();
			}
		}).start();
		
		
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("main finish..........");
		
	}
}
