package com.jimmie.test.redis;

import java.util.Iterator;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Test1 {

	public static Jedis jedis = null;

	static {
		JedisPool ll = new JedisPool("192.168.248.55");
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

}
