package com.jimmie.test.事件驱动.event.demo;

import java.util.Enumeration;
import java.util.Vector;

public class DemoSource {     
    private Vector<DemoListener> repository = new Vector<DemoListener>();//监听自己的监听器队列     
    public DemoSource(){}     
    public void addDemoListener(DemoListener dl) {     
           repository.addElement(dl);     
    }     
    public void notifyDemoEvent() {//通知所有的监听器     
           Enumeration<DemoListener> enu = repository.elements();     
           while(enu.hasMoreElements()) {     
                 DemoListener dl = enu.nextElement();     
                 dl.handleEvent(new DemoEvent(this));     
           }     
    }   
    
}  