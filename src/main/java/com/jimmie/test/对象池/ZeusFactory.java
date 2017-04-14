package com.jimmie.test.对象池;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class ZeusFactory extends BasePooledObjectFactory<Zeus>{

	@Override
	public Zeus create() throws Exception {
		// TODO Auto-generated method stub
		return new Zeus();
	}

	@Override
	public PooledObject<Zeus> wrap(Zeus zeus) {
		// TODO Auto-generated method stub
		return new DefaultPooledObject<Zeus>(zeus);
	}
	
}
