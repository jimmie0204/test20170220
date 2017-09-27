package com.jimmie.test.akka.remote.client;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jimmie.test.akka.remote.server.Op;
import com.jimmie.test.akka.spring.SpringExt;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import scala.concurrent.duration.Duration;

@Component
public class ClientStarter {

    private static Logger logger = LoggerFactory.getLogger(ClientStarter.class);  
	@Autowired
	private ActorSystem actorSystem;

	@Autowired
	private SpringExt springExt;
	
	
	public void start() throws Exception{
		logger.info("start lookup");  
		final String path = "akka.tcp://serverSystem@127.0.0.1:2552/user/calculator";  
		final ActorRef lookup = actorSystem.actorOf(springExt.props("LookupActor", path), "lookup");  
		final Random r = new Random();  
		actorSystem.scheduler().schedule(Duration.create(1, TimeUnit.SECONDS), Duration.create(8, TimeUnit.SECONDS), new Runnable() {  
		  
		    @Override  
		    public void run() {  
		        if (r.nextInt(100) % 2 == 0) {  
		        	logger.info("用lookup处理加法");
		            lookup.tell(new Op.Add(r.nextInt(100), r.nextInt(100)), null);  
		        } else { 
		        	logger.info("用lookup处理垃圾信息");
		        	lookup.tell("lajixinxi", null);
		        }  
		  
		    }  
		}, actorSystem.dispatcher());  
	}
}
