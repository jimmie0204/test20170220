package com.jimmie.test.akka.scheduler;

import java.util.concurrent.TimeUnit;

import akka.actor.UntypedActor;

/**
 * 打招呼的Actor
 * @author SUN
 * @version 1.0
 * @Date 16/1/6 21:40
 */
public class Greeter extends UntypedActor{

    String greeting = "jjjjj";
    
    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof WhoToGreet)
            greeting = "hello, " + ((WhoToGreet) message).who;
        else if (message instanceof Greet){
//        	TimeUnit.SECONDS.sleep(5);
            // 发送招呼消息给发送消息给这个Actor的Actor
            getSender().tell(new Greeting(greeting), getSelf());
        }else
        	unhandled(message);
    }
}