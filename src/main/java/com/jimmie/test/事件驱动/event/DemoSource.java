package com.jimmie.test.事件驱动.event;

import java.util.EventObject;
import java.util.Vector;

//包装了监听者的管理
public class DemoSource {     
    private Vector<DemoListener> repository = new Vector<DemoListener>();//监听自己的监听器队列     
    public Vector<DemoListener> getRepository() {
		return repository;
	}
	public void setRepository(Vector<DemoListener> repository) {
		this.repository = repository;
	}
	
	public DemoSource(){}     
    public void addDemoListener(DemoListener dl) {     
           repository.addElement(dl);     
    }     
/*    public void notifyDemoEvent() {//通知所有的监听器     
           Enumeration<DemoListener> enu = repository.elements();     
           while(enu.hasMoreElements()) {     
                 DemoListener dl = enu.nextElement();     
                 dl.handleEvent(new DemoEvent(this));     
           }     
    } */    
    
    public void dispatcher(EventObject event){
    	
    }
}  