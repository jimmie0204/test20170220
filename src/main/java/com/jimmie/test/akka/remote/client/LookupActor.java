package com.jimmie.test.akka.remote.client;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;

import com.jimmie.test.akka.remote.server.Op;

import akka.actor.ActorIdentity;
import akka.actor.ActorRef;
import akka.actor.Identify;
import akka.actor.ReceiveTimeout;
import akka.actor.Terminated;
import akka.actor.UntypedActor;
import akka.japi.Procedure;
import scala.concurrent.duration.Duration;

@Named("LookupActor")  
@Scope("prototype")  
public class LookupActor extends UntypedActor {  
      
    private static Logger logger = LoggerFactory.getLogger(LookupActor.class);  
  
    private final String path;  
    private ActorRef calculator = null;  
  
    public LookupActor(String path) {  
        this.path = path;  
        sendIdentifyRequest();  
    }  
  
    private void sendIdentifyRequest() {  
        getContext().actorSelection(path).tell(new Identify(path), getSelf());  //获取远程actor
        getContext().system().scheduler().scheduleOnce(Duration.create(3, TimeUnit.SECONDS), getSelf(),  
                ReceiveTimeout.getInstance(), getContext().dispatcher(), getSelf());  
    }  
  
    @Override  
    public void onReceive(Object message) throws Exception {  
        if (message instanceof ActorIdentity) {  
            calculator = ((ActorIdentity) message).getRef();  
            if (calculator == null) {  
                logger.info("Remote actor not available: " + path);  
            } else {  
                getContext().watch(calculator);  
                getContext().become(active,true);
            }  
  
        } else if (message instanceof ReceiveTimeout) {  
            sendIdentifyRequest();  
  
        } else {  
            logger.info("Not ready yet");  
  
        }  
    }  
  
    Procedure<Object> active = new Procedure<Object>() {  
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override  
        public void apply(Object message) {  
            if (message instanceof Op.Add) {  
                // send message to server actor  
                calculator.tell(message, getSelf());  
  
            } else if (message instanceof Op.AddResult) {  
                Op.AddResult result = (Op.AddResult) message;  
                logger.info(String.format("Add result: %d + %d = %d\n", result.getN1(), result.getN2(), result.getResult()));  
                ActorRef sender = getSender();  
                logger.info("Sender is: " + sender);  
  
            }  else if (message instanceof Terminated) {  
                logger.info("Calculator terminated");  
                sendIdentifyRequest();  
                getContext().unbecome();  
  
            } else if (message instanceof ReceiveTimeout) {  
                // ignore  
  
            } else {  
            	logger.info("lookupActor不能处理这个信息。。。");
                unhandled(message);  
            }  
  
        }  
    };  
} 