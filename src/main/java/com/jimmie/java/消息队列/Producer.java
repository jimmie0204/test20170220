package com.jimmie.java.消息队列;


public class Producer implements Runnable{

	private boolean flag = true;
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	private MessageQueue queue;
	public Producer(){};
	
	public Producer(MessageQueue queue){
		this.queue = queue;
	};
	
	public void produce(String msg){
		try {
			queue.addMsg(msg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		for(int i=1;i<=10;i++){
			produce("msg"+i);
		}
	}
	
}
