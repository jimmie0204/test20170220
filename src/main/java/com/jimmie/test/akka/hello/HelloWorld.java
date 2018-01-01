package com.jimmie.test.akka.hello;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

public class HelloWorld extends UntypedActor {

  @Override
  public void preStart() {
    // create the greeter actor
    final ActorRef greeter = getContext().actorOf(Props.create(Greeter.class), "greeter111");
    // tell it to perform the greeting
    greeter.tell(Greeter.Msg.GREET, getSelf());
    greeter.tell(Greeter.Msg.DONE, getSelf());
  }

  @Override
  public void onReceive(Object msg) {
    if (msg == Greeter.Msg.DONE) {
      // when the greeter is done, stop this actor and with it the application
    	System.out.println("收到你的恢复了");
      getContext().stop(getSelf());//結束自己
    } else
      unhandled(msg);
  }
}
