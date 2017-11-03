package com.jimmie.java.消息队列;


public class Consumer implements Runnable{

	private boolean flag = true;
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	private MessageQueue queue;
	public Consumer(){};
	
	public Consumer(MessageQueue queue){
		this.queue = queue;
	};
	
	public String consume(){
		try {
			return queue.takeMsg();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void run() {
		while(flag){
			System.out.println(consume());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
