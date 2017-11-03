package com.jimmie.java.消息队列;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;


public class MessageQueue {


	private static BlockingDeque<String> que = new LinkedBlockingDeque<String>(5);
	
	public void addMsg(String msg) throws InterruptedException{
		que.put(msg);
		System.out.println("添加一条消息"+msg);
	}
	
	public String takeMsg() throws InterruptedException{
		return que.takeFirst();
	}
	
	public int size(){
		return que.size();
	}
}
