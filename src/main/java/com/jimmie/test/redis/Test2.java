package com.jimmie.test.redis;

import java.util.Iterator;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Test2 {

	public static Jedis jedis = null;
	
	static{
		JedisPool ll = new JedisPool("172.16.30.71");
		jedis = ll.getResource();
	}
	public static void close(){
		jedis.disconnect();
	}
	
	public static void print(Set set){
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			String tmp = it.next();
			System.out.println(tmp);
		}
	}
	public static void main(String[] args) {
		
//		jedis.incr("gh");
//		System.out.println(jedis.get("gh"));
//		jedis.decr("gh");
		
		
		jedis.zadd("zeus", 12, "tom12");
		jedis.zadd("zeus", 1, "tom1");jedis.zadd("zeus", 5, "tom5");jedis.zadd("zeus", 3, "tom3");jedis.zadd("zeus", 15, "tom15");
		
		Set<String> ll = jedis.zrange("zeus", 0, 3);
		Set<String> ll2 = jedis.zrevrange("zeus", 0, 3);
		Set<String> ll3 = jedis.zrangeByScore("zeus", 0, 3);
		close();
		print(ll);
		System.out.println("========");
		print(ll2);
		System.out.println("========");
		print(ll3);
		
	}

}
