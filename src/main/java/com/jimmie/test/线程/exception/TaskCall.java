package com.jimmie.test.线程.exception;

import java.util.concurrent.Callable;

public class TaskCall implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		 System.out.println("执行任务");
	    int num  = Integer.parseInt("TT");
		return num;
	}
}