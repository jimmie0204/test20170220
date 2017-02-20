package com.jimmie.test.redis.sharding;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring-mvc.xml"})
@ContextConfiguration(locations = {"classpath:redis/spring.xml"})
public class JedisTest {
	
	@Autowired
	RedisClientTemplate redisClientTemplate;
	
	@Test
	public void jedisTest() throws Exception {
		
		System.out.println("start test redis");
		
		redisClientTemplate.set("aaaa", "bbbbb");
		
		String result = redisClientTemplate.get("aaaa",null);
		
		System.out.println(result);
		
	}

}
