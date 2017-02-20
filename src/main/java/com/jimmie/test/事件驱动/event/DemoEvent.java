package com.jimmie.test.事件驱动.event;

import java.util.List;

public class DemoEvent extends java.util.EventObject {     
    /**
	 * 
	 */
	private static final long serialVersionUID = -2039753861499653855L;
	
	private List<Long> idList;
	
	public DemoEvent(Object source,List<Long> idList) {     
      super(source);//source—事件源对象—如在界面上发生的点击按钮事件中的按钮     
       //所有 Event 在构造时都引用了对象 "source"，在逻辑上认为该对象是最初发生有关 Event 的对象 
      this.setIdList(idList);
    }     
    public void say() {     
           System.out.println("This is say method...");     
    }
	public List<Long> getIdList() {
		return idList;
	}
	public void setIdList(List<Long> idList) {
		this.idList = idList;
	}     
} 
