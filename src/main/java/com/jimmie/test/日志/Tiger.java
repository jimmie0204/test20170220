package com.jimmie.test.日志;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tiger {

	public static Logger log = LoggerFactory.getLogger(Tiger.class);
	
	public void eat(){
		log.info("im a tiger， im eating");
	}
}
