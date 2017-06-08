package com.jimmie.test.redis.lock;

import redis.clients.jedis.Jedis;

public class LockTest {

	public class Count extends Thread{
		public void run(){
			Jedis jedis = new Jedis("172.16.30.71", 6379);
			System.out.println(jedis.lpop("rrr"));;
			jedis.close();
		}
	}
//	@TestJunit单元测试不支持多线程
	public static void main(String[] args) {
		
		Jedis jedis = new Jedis("172.16.30.71", 6379);
//		jedis.del("rrr");
		jedis.rpush("rrr", "1");
		jedis.rpush("rrr", "2");
		jedis.rpush("rrr", "3");
		jedis.rpush("rrr", "4");
		jedis.rpush("rrr", "5");
		jedis.rpush("rrr", "6");
		jedis.rpush("rrr", "7");
		jedis.rpush("rrr", "8");
		jedis.rpush("rrr", "9");
		jedis.rpush("rrr", "10");
//		System.out.println(jedis.lpop("rrr"));
		jedis.close();
		LockTest ll = new LockTest();
		
		for(int i=0;i<100;i++){
			ll.new Count().start();
		}
	}
}
