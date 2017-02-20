package com.jimmie.test.redis;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class Opera {

	@Test
	public void pipline(){
		
	}
	
	@Test
	public void test1(){
		Jedis jedis = new Jedis("172.16.3.254", 6379);
		jedis.set("hi", "jimmie");
		System.out.println("success");
		jedis.close();
	}
	
	@Test
	public void test2(){
		Jedis jedis = new Jedis("172.16.3.254", 6379);
		System.out.println(jedis.get("hi"));;
		jedis.close();
	}
	
	@Test
	public void test3(){
		Jedis jedis = new Jedis("172.16.3.254", 6379);
		System.out.println(jedis.getSet("hi", "jimmie2"));
		jedis.close();
	}
}
