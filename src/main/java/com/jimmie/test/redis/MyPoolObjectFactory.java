package com.jimmie.test.redis;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import redis.clients.jedis.Jedis;

public class MyPoolObjectFactory extends BasePooledObjectFactory<Jedis>{

	@Override
	public Jedis create() throws Exception {
		return new Jedis();
	}

	@Override
	public PooledObject<Jedis> wrap(Jedis paramT) {
		return new DefaultPooledObject<Jedis>(paramT);
	}

}
