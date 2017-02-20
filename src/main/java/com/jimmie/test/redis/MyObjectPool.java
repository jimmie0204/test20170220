package com.jimmie.test.redis;

import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisException;

public class MyObjectPool {

	private ObjectPool<Jedis> pool;
	
	public MyObjectPool(){
		pool = new GenericObjectPool<Jedis>(new MyPoolObjectFactory());
	}
	
	public Jedis getJedis(){
		try {
			return pool.borrowObject();
		} catch (Exception e) {
			throw new JedisException(
				    "Could not borrow the resource from the pool", e);
		}
	}
	
	public void retrunJedis(Jedis temp){
		try {
			temp.resetState();
			pool.returnObject(temp);
		} catch (Exception e) {
			throw new JedisException(
				    "Could not return the resource to the pool", e);
		}
	}
	
}
