package com.jimmie.test.akka.spring;

import javax.annotation.Resource;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import akka.actor.UntypedActor;

@Named("CountingActor")  
@Scope("prototype")  
public class CountingActor extends UntypedActor {  
  
    public static class Count {  
    }  
  
    public static class Get {  
    }  
  
    // the service that will be automatically injected  
    @Resource  
    private CountingService countingService;  
  
    private int count = 0;  
  
    @Override  
    public void onReceive(Object message) throws Exception {  
        if (message instanceof Count) {  
            count = countingService.increment(count);  
        } else if (message instanceof Get) {  
            getSender().tell(count, getSelf());  
        } else {  
            unhandled(message);  
        }  
    }  
}