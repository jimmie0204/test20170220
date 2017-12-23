package com.jimmie.test.线程.status;

public class WaitTest{
	
	public synchronized void waitFor(){
		try {
			System.out.println(Thread.currentThread().getName()+"开始wait。。。");
			wait();
		} catch (InterruptedException e) {
			System.out.println("wait 被打断！！");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		WaitTest wt = new WaitTest();
		MyThread myThread = new MyThread(wt,"jimmie-1");
		myThread.start();;
		/*new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
					myThread.interrupt();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();;*/
		
	}
	
	public static class MyThread  extends Thread{
		private  WaitTest wt;
		
		public MyThread(WaitTest wt,String name) {
			super(name);
			this.wt = wt;
		}

		public void run(){
			wt.waitFor();
		}

	}
}