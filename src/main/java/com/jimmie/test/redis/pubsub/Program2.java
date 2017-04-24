package com.jimmie.test.redis.pubsub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Program2 {
    
    public static final String CHANNEL_NAME = "MyChannel";
    //我这里的Redis是一个集群，192.168.56.101和192.168.56.102都可以使用
    public static final String REDIS_HOST = "172.16.3.254";
    public static final int REDIS_PORT = 6378;
    
    private final static Logger LOGGER = LoggerFactory.getLogger(Program2.class);
    private final static JedisPoolConfig config  = new JedisPoolConfig();
    private final static JedisPool JEDIS_POOL = 
            new JedisPool(config, REDIS_HOST, REDIS_PORT, 0);
    
    
    public static void main(String[] args) throws Exception {
        final Jedis subscriberJedis = JEDIS_POOL.getResource();
        final Subscriber subscriber = new Subscriber();
        //订阅线程：接收消息
        try {
            LOGGER.info("Subscribing to \"MyChannel\". This thread will be blocked.");
            //使用subscriber订阅CHANNEL_NAME上的消息，这一句之后，线程进入订阅模式，阻塞。
            subscriberJedis.subscribe(subscriber, CHANNEL_NAME);
            
            //当unsubscribe()方法被调用时，才执行以下代码
            LOGGER.info("Subscription ended.");
        } catch (Exception e) {
            LOGGER.error("Subscribing failed.", e);
        }
        
        //Unsubscribe
        subscriber.unsubscribe();
        subscriberJedis.close();
    }
}