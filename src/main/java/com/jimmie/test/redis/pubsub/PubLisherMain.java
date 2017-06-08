package com.jimmie.test.redis.pubsub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class PubLisherMain {

	public static final String CHANNEL_NAME = "MyChannel";
	// 我这里的Redis是一个集群，192.168.56.101和192.168.56.102都可以使用
	public static final String REDIS_HOST = "172.16.30.71";
	public static final int REDIS_PORT = 6378;

	private final static Logger LOGGER = LoggerFactory.getLogger(Program.class);
	private final static JedisPoolConfig config = new JedisPoolConfig();
	private final static JedisPool JEDIS_POOL = new JedisPool(config, REDIS_HOST, REDIS_PORT, 0);

	public static void main(String[] args) {
		final Jedis publisherJedis = JEDIS_POOL.getResource();
		LOGGER.info("启动订阅频道，开始发布消息");
		// 主线程：发布消息到CHANNEL_NAME频道上
		new Publisher(publisherJedis, CHANNEL_NAME).startPublish();
		publisherJedis.close();

	}

}
