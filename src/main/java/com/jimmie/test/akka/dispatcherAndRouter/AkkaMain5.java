package com.jimmie.test.akka.dispatcherAndRouter;

import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class AkkaMain5 {

    public static void main(String[] args) throws Exception {
        final ActorSystem system = ActorSystem.create("jimmie001", ConfigFactory.load("akka/akka-dispather.conf")
                .getConfig("demo5"));

        // 创建一个到greeter Actor的管道
        final ActorRef controlActor = system.actorOf(Props.create(ControlActor.class), "control");

        controlActor.tell(new StartCommand(10),ActorRef.noSender());

        //system.shutdown();
    }
}