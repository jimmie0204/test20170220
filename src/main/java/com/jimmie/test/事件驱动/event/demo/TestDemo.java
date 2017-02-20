package com.jimmie.test.事件驱动.event.demo;

public class TestDemo {
	DemoSource ds;

	public TestDemo() {
		try {
			ds = new DemoSource();
			// 将监听器在事件源对象中登记：
			DemoListener listener1 = new DemoListener();
			ds.addDemoListener(listener1);
			ds.addDemoListener(new DemoListener() {
				public void handleEvent(DemoEvent event) {
					System.out.println("Method come from 匿名类...");
				}
			});
			ds.notifyDemoEvent();// 触发事件、通知监听器
			System.out.println("主流程结束");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String args[]) {
		new TestDemo();
	}
}