package com.jimmie.test.redis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Test3 {
	
	public static Jedis jedis = null;

	@Before
	public void connect(){
		JedisPool ll = new JedisPool("172.16.30.71",6378);
		jedis = ll.getResource();
	}
	
	@After
	public void close(){
		jedis.disconnect();
	}
	
	
	@Test
	public void setTest(){
		jedis.sadd("jimmie:set", "aaa");
		jedis.sadd("jimmie:set", "bbb");
		System.out.println(jedis.smembers("jimmie:set"));
	}
	
	
}
