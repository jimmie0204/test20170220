package com.jimmie.test.akka.remote1.calculator;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.Random;

import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import scala.concurrent.duration.Duration;

public class LookupApplication {
  public static void main(String[] args) {
    if (args.length == 0 || args[0].equals("Lookup"))
      startRemoteLookupSystem();
  }

  public static void startRemoteLookupSystem() {

    final ActorSystem system = ActorSystem.create("LookupSystem",
        ConfigFactory.load("remotelookup"));
    final String path = "akka.tcp://CalculatorSystem@127.0.0.1:12552/user/calculator";
    final ActorRef actor = system.actorOf(
        Props.create(LookupActor.class, path), "lookupActor");

    System.out.println("Started LookupSystem");
    final Random r = new Random();
    system.scheduler().schedule(Duration.create(1, SECONDS),
        Duration.create(8, SECONDS), new Runnable() {
          @Override
          public void run() {
            if (r.nextInt(100) % 2 == 0) {
              actor.tell(new Op.Add(r.nextInt(100), r.nextInt(100)), null);
            } else {
              actor.tell(new Op.Subtract(r.nextInt(100), r.nextInt(100)), null);
            }

          }
        }, system.dispatcher());

  }
}
