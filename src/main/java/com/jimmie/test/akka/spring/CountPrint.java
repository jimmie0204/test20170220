package com.jimmie.test.akka.spring;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Inbox;
import akka.pattern.Patterns;
import akka.util.Timeout;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.FiniteDuration;

@Component
public class CountPrint {

	@Autowired
	private ActorSystem actorSystem;

	@Autowired
	private SpringExt springExt;
	
	public void print() throws Exception{
		ActorRef counter = actorSystem.actorOf(springExt.props("CountingActor"), "counter");  
		  
		// Create the "actor-in-a-box"  
		       final Inbox inbox = Inbox.create(actorSystem);  
		      
		// tell it to count three times  
		       inbox.send(counter, new CountingActor.Count());  
		       inbox.send(counter,new CountingActor.Count());  
		       inbox.send(counter, new CountingActor.Count());  
		  
		// print the result  
		FiniteDuration duration = FiniteDuration.create(3, TimeUnit.SECONDS);  
		Future<Object> result = Patterns.ask(counter, new CountingActor.Get(), Timeout.durationToTimeout(duration));  
		try {  
		    System.out.println("Got back " + Await.result(result, duration));  
		} catch (Exception e) {  
		    System.err.println("Failed getting result: " + e.getMessage());  
		    throw e;  
		}  
	}
}
