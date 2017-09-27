package com.jimmie.test.akka.remote1.server;

import com.typesafe.config.ConfigFactory;

import akka.actor.ActorSystem;

public class CreationServer {

  public static void main(String[] args) {
    if (args.length == 0 || args[0].equals("CalculatorWorker"))
      startRemoteWorkerSystem();
  }

  public static void startRemoteWorkerSystem() {
    ActorSystem.create("CalculatorWorkerSystem",
        ConfigFactory.load(("calculator")));
    System.out.println("Started CalculatorWorkerSystem");
  }
}
