package com.jimmie.test.事件驱动.EventBus.test1;


import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class EventBusTest2 {

	@Test
	 public void test() throws InterruptedException {
		  
		DataObserver1 observer1 = new DataObserver1();
		EventBusCenter.register(observer1);

		System.out.println("============   start  ====================");

		// 只有注册的参数类型为String的方法会被调用
		EventBusCenter.post(123);
		EventBusCenter.post(11);

		System.out.println("============    end           =============");
	}

	@Test
	public void test2() throws Exception {

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		DataObserver1 observer1 = new DataObserver1();
		EventBusCenter.register(observer1);

		System.out.println("============   start  ====================");

		// 只有注册的参数类型为String的方法会被调用
		executorService.submit(()->{EventBusCenter.post(123);});
		executorService.submit(()->EventBusCenter.post(11));

		System.out.println("============    end           =============");
		System.in.read();
	}

	@Test
	public void test3() throws Exception {

		DataObserver1 observer1 = new DataObserver1();
		AsynEventBusCenter.register(observer1);

		System.out.println("============   start  ====================");

		// 只有注册的参数类型为String的方法会被调用
		AsynEventBusCenter.post(123);
		AsynEventBusCenter.post(11);
		System.out.println("============    end           =============");
		System.in.read();
	}
	@Test
	public void test4() throws InterruptedException {

		DataObserver3 observer1 = new DataObserver3();
		EventBusCenter.register(observer1);

		System.out.println("============   start  ====================");

		// 只有注册的参数类型为String的方法会被调用
		EventBusCenter.post(123);
		EventBusCenter.post("1sd1");

		System.out.println("============    end           =============");
	}

	@Test
	public void test5() throws Exception {

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		DataObserver3 observer1 = new DataObserver3();
		EventBusCenter.register(observer1);

		System.out.println("============   start  ====================");

		// 只有注册的参数类型为String的方法会被调用
		executorService.submit(()->{EventBusCenter.post(123);});
		executorService.submit(()->EventBusCenter.post(11));

		System.out.println("============    end           =============");
		System.in.read();
	}


	@Test
	public void test6() throws Exception {

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		DataObserver4 observer1 = new DataObserver4();
		EventBusCenter.register(observer1);

		System.out.println("============   start  ====================");

//		EventBusCenter.post(new Parent());
		EventBusCenter.post(new Child());

		System.out.println("============    end           =============");
		System.in.read();
	}

}
