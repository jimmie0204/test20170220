package com.jimmie.test.redis;

import java.util.*;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Test1 {

	public static Jedis jedis = null;

	static {
		JedisPool ll = new JedisPool("127.0.0.1");
		jedis = ll.getResource();
	}

	public static void close() {
		jedis.disconnect();
	}

	// ����
	public static void testJiaoji() {
		String[] mems1 = new String[] { "2", "3", "4" };
		String[] mems2 = new String[] { "1", "3", "4" };
		jedis.sadd("g1", mems1);
		jedis.sadd("g2", mems2);
		Set<String> set = jedis.sinter("g1", "g2");
		Iterator<String> it = set.iterator();
		StringBuffer temp = new StringBuffer("[");

		while (it.hasNext()) {
			temp.append(it.next()).append(",");
		}
		temp.append("end]");
		System.out.println(temp.toString());

	}

	// �
	public static void testChaji() {
		String[] mems1 = new String[] { "2", "3", "4" };
		String[] mems2 = new String[] { "1", "3", "4" };
		jedis.sadd("g1", mems1);
		jedis.sadd("g2", mems2);
		Set<String> set = jedis.sdiff("g2", "g1");
		long p = jedis.sdiffstore("giii", "g1", "g2");
		System.out.println(p);
		System.out.println(jedis.smembers("giii"));
		Iterator<String> it = set.iterator();
		StringBuffer temp = new StringBuffer("[");

		while (it.hasNext()) {
			temp.append(it.next()).append(",");
		}
		temp.append("end]");
		System.out.println(temp.toString());

	}

	// ����
	public static void testBingji() {
		String[] mems1 = new String[] { "2", "3", "4" };
		String[] mems2 = new String[] { "1", "3", "4" };
		jedis.sadd("g1", mems1);
		jedis.sadd("g2", mems2);
		Set<String> set = jedis.sunion("g1", "g2");
		Iterator<String> it = set.iterator();
		StringBuffer temp = new StringBuffer("[");

		while (it.hasNext()) {
			temp.append(it.next()).append(",");
		}
		temp.append("end]");
		System.out.println(temp.toString());

	}
	

	public static void main(String[] args) {
		testJiaoji();
		testChaji();
		testBingji();
		close();
	}

	@Test
	public void test1(){
		Long hset = jedis.hset("nevermore", "m", "120");
		System.out.println(hset);
		String hget = jedis.hget("nevermore", "r");
		System.out.println(hget);

		Map<String,String> map = new HashMap<>();
		map.put("ma","a");
		map.put("mc","c");
		String mt = jedis.hmset("mt", map);
		System.out.println(mt);
		List<String> hmget = jedis.hmget("mt", "ma", "mb");
		System.out.println(hmget);
		close();


	}

	@Test
	public void test2(){
		String lion = jedis.set("lion", "120");
		System.out.println(lion);
		Long hset = jedis.hset("lion", "m", "120");
		System.out.println(hset);
		close();

	}

	@Test
	public void test3(){
		Long hset = jedis.hset("doom", "m", "120");
		Long e1 = jedis.expire("doom", 60);
		Long ttl1 = jedis.pttl("doom");
		System.out.println("第一次设置ttl之后剩余的生存时间为："+ttl1);

		Map<String,String> map = new HashMap<>();
		map.put("z","a");
		map.put("r","c");
		String mt = jedis.hmset("doom", map);

		Long e2 = jedis.expire("doom", 600);
		Long ttl2 = jedis.pttl("doom");
		System.out.println("第二次设置ttl之后剩余的生存时间为："+ttl2);
		close();


	}
}
