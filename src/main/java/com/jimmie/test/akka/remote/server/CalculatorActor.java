package com.jimmie.test.akka.remote.server;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;

import akka.actor.UntypedActor;

@Named("CalculatorActor")  
@Scope("prototype")  
public class CalculatorActor extends UntypedActor {  
      
    private static Logger logger = LoggerFactory.getLogger(CalculatorActor.class);  
    
    @Override
    public void preStart() throws Exception {
    	logger.info("生成了一个CalculatorActor。。。");
    }
  
    @Override  
    public void onReceive(Object message) {  
  
        if (message instanceof Op.Add) {  
            Op.Add add = (Op.Add) message;  
            logger.info("Calculating " + add.getN1() + " + " + add.getN2());  
            Op.AddResult result = new Op.AddResult(add.getN1(), add.getN2(), add.getN1() + add.getN2());  
            getSender().tell(result, getSelf());  
  
        } else {  
        	logger.info("不能处理这个消息。。。"+message);
            unhandled(message);  
        }  
    }  
} 