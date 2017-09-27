package com.jimmie.test.akka.remote.server;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jimmie.test.akka.spring.CountingActor;
import com.jimmie.test.akka.spring.SpringExt;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Inbox;
import akka.pattern.Patterns;
import akka.util.Timeout;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.FiniteDuration;

@Component
public class ServerStarter {

    private static Logger logger = LoggerFactory.getLogger(ServerStarter.class);  
	@Autowired
	private ActorSystem actorSystem;

	@Autowired
	private SpringExt springExt;
	
	
	public void start() throws Exception{
		logger.info("Start calculator");  
		final ActorRef calculator = actorSystem.actorOf(springExt.props("CalculatorActor"), "calculator");  
		 final Inbox inbox = Inbox.create(actorSystem);  
		 inbox.send(calculator, 1);
//		actorMap.put("calculator", calculator);  
		logger.info("Started calculator");  
	}
}
