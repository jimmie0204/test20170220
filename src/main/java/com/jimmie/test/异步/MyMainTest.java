package com.jimmie.test.异步;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyMainTest {

	public static void main(String[] args) {

		ExecutorService myexecutor = Executors.newCachedThreadPool();

		Callable<Integer> call = new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
//				Thread.sleep(50000);
				int i=1/0;
				return 10;
			}
		};

		Future<Integer> future = myexecutor.submit(call);

		MyPromise<Integer> myPromise = new MyPromise<Integer>(future, myexecutor);

		myPromise.addListenter(new CallBack<Integer>() {

			@Override
			public void onSuccess(Integer value) {
				System.out.println("success do sth.." + value);
			}

			@Override
			public void onFailure(Throwable t) {
				System.out.println("fail do sth.." + t.getMessage());

			}

			@Override
			public void onCancel() {
				System.out.println("cancel do sth..");

			}
		});

		/*try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		myPromise.cancel();
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
