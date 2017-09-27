package com.jimmie.test.akka.remote1.server;

import com.jimmie.test.akka.remote1.calculator.CalculatorActor;
import com.typesafe.config.ConfigFactory;

import akka.actor.ActorSystem;
import akka.actor.Props;

public class LookupServer {
  public static void main(String[] args) {
    if (args.length == 0 || args[0].equals("Calculator"))
      startRemoteCalculatorSystem();
  }

  public static void startRemoteCalculatorSystem() {
    final ActorSystem system = ActorSystem.create("CalculatorSystem",
        ConfigFactory.load(("calculator")));
    system.actorOf(Props.create(CalculatorActor.class), "calculator");
    System.out.println("Started CalculatorSystem");
  }

}
