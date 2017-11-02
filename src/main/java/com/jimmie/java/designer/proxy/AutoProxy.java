package com.jimmie.java.designer.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AutoProxy implements InvocationHandler{

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {


		System.out.println("这是动态代理，啥也不代卖");
		return null;
	}

}
