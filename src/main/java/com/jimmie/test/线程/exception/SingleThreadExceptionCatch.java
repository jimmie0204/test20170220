package com.jimmie.test.线程.exception;

public class SingleThreadExceptionCatch {
	
	public static void main(String[] args) {
		
		 Task task = new Task();
	     Thread thread = new Thread(task);
//	     thread.setUncaughtExceptionHandler(new RewriteUncatchtExceptionHandler());
	     thread.start();
	}

}
