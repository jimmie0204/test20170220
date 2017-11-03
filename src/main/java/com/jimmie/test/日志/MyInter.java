package com.jimmie.test.日志;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface MyInter {

	public static final Logger log = LoggerFactory.getLogger("jj");
	
	public int pro = 0;
	
	public void doSth(Tiger tiger);
}
