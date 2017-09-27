package com.jimmie.test.akka.remote1.calculator;

import static java.util.concurrent.TimeUnit.SECONDS;

import akka.actor.ActorIdentity;
import akka.actor.ActorRef;
import akka.actor.Identify;
import akka.actor.ReceiveTimeout;
import akka.actor.Terminated;
import akka.actor.UntypedActor;
import akka.japi.Procedure;
import scala.concurrent.duration.Duration;

public class LookupActor extends UntypedActor {

  private final String path;
  private ActorRef calculator = null;

  @Override
  public void preStart() throws Exception {
    super.preStart();
    System.out.println("LookupActor创建 context().self()==="+context().self());
    System.out.println("LookupActor context().self().path()==="+context().self().path());
    System.out.println("LookupActor context().parent()==="+context().parent());
    System.out.println("LookupActor context().parent().path()==="+context().parent().path());
    System.out.println("LookupActor context().self().path().parent()==="+context().self().path().parent());
  }

  public LookupActor(String path) {
    System.out.println("LookupActor 构造方法。。。");
    this.path = path;
    sendIdentifyRequest();
  }

  private void sendIdentifyRequest() {
    getContext().actorSelection(path).tell(new Identify(path), getSelf());
    getContext()
        .system()
        .scheduler()
        .scheduleOnce(Duration.create(3, SECONDS), getSelf(),
            ReceiveTimeout.getInstance(), getContext().dispatcher(), getSelf());
  }

  @Override
  public void onReceive(Object message) throws Exception {

    if (message instanceof ActorIdentity) {
      calculator = ((ActorIdentity) message).getRef();
      if (calculator == null) {
        System.out.println("Remote actor not available: " + path);
      } else {
        getContext().watch(calculator);
        getContext().become(active, true);
      }

    } else if (message instanceof ReceiveTimeout) {
      System.out.println("LookupActor中超时重新请求创建========================");
      sendIdentifyRequest();

    } else {
      System.out.println("Not ready yet");

    }
  }

  Procedure<Object> active = new Procedure<Object>() {
    @Override
    public void apply(Object message) {
      if (message instanceof Op.MathOp) {
        // send message to server actor
        calculator.tell(message, getSelf());

      } else if (message instanceof Op.AddResult) {
        Op.AddResult result = (Op.AddResult) message;
        System.out.printf("Add result: %d + %d = %d\n", result.getN1(),
            result.getN2(), result.getResult());

      } else if (message instanceof Op.SubtractResult) {
        Op.SubtractResult result = (Op.SubtractResult) message;
        System.out.printf("Sub result: %d - %d = %d\n", result.getN1(),
            result.getN2(), result.getResult());

      } else if (message instanceof Terminated) {
        System.out.println("Calculator terminated");
        sendIdentifyRequest();
        getContext().unbecome();

      } else if (message instanceof ReceiveTimeout) {
        System.out.println("什么鬼，怎么还有timeout在become中。。。");

      } else {
        unhandled(message);
      }

    }
  };
}
