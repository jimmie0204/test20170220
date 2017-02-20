package com.jimmie.test.redis.sharding;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	
	
	public static void main(String[] args) throws Exception {
		ApplicationContext act = new ClassPathXmlApplicationContext("classpath:redis/spring.xml");
		
		RedisClientTemplate redisClientTemplate = (RedisClientTemplate) act.getBean("redisClientTemplate");
		
		System.out.println("start test redis");
		
		redisClientTemplate.set("aaaa", "bbbbb");
		
		String result = redisClientTemplate.get("aaaa",null);
		
		System.out.println(result);
	}
}
