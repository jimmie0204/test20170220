package com.jimmie.java.消息队列;

public class MainTest {

	public static void main(String[] args) {
		MessageQueue q = new MessageQueue();
		new Thread(new Consumer(q)).start();
		new Thread(new Producer(q)).start();
	}

}
