package com.jimmie.test.事件驱动.event;

import java.util.ArrayList;
import java.util.List;

public class TestDemo {
	DemoSource ds;

	public TestDemo() {
		try {
			ds = new DemoSource();
			// 将监听器在事件源对象中登记：
			DemoListener listener1 = new DemoListener();
			ds.addDemoListener(listener1);

			List<Long>idList = new ArrayList<Long>();
			idList.add(1l);
			idList.add(451l);
			idList.add(177l);
			
			DemoEvent event = new DemoEvent(ds,idList);
			EventManager manager = new EventManager();
			manager.setSource(ds);
			manager.pushEvent(event);
			System.out.println("主流程结束");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String args[]) {
		new TestDemo();
	}
}