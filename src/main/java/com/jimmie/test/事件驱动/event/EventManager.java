package com.jimmie.test.事件驱动.event;

import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EventManager {

	private DemoSource source;
	
	public DemoSource getSource() {
		return source;
	}

	public void setSource(DemoSource source) {
		this.source = source;
	}

	private static ExecutorService executor = Executors.newFixedThreadPool(6);
	
	public void pushEvent(final DemoEvent event){
		Vector<DemoListener> listeners= source.getRepository();
		for(final DemoListener temp:listeners){
			executor.execute(new Runnable() {
				
				@Override
				public void run() {
					temp.handleEvent(event);
					
				}
			});
		}
		
		executor.shutdown();
	}
}
