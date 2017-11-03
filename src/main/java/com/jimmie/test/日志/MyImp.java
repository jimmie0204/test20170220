package com.jimmie.test.日志;

public class MyImp implements MyInter {

	@Override
	public void doSth(Tiger tiger) {
		log.info("我是接口实现类里面的日志");
		tiger.eat();
		log.info("pro=========="+(pro));
	}

}
