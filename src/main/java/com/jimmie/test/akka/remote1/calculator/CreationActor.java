package com.jimmie.test.akka.remote1.calculator;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.ReceiveTimeout;
import akka.actor.UntypedActor;

public class CreationActor extends UntypedActor {

  ActorRef calculator;

  @Override
  public void preStart() throws Exception {
    super.preStart();
    System.out.println("CreationActor创建 context().self()==="+context().self());
    System.out.println("CreationActor context().self().path()==="+context().self().path());
    System.out.println("CreationActor context().parent()==="+context().parent());
    System.out.println("CreationActor context().parent().path()==="+context().parent().path());
    System.out.println("CreationActor context().self().path().parent()==="+context().self().path().parent());
    calculator = getContext().actorOf(
            Props.create(CalculatorActor.class));
    System.out.println("calculator RefPath=="+calculator.path()+"==code=="+calculator.hashCode());
  }

  @Override
  public void onReceive(Object message) throws Exception {

    if (message instanceof Op.MathOp) {
      calculator.tell(message, getSelf());

    } else if (message instanceof Op.MultiplicationResult) {
      Op.MultiplicationResult result = (Op.MultiplicationResult) message;
      System.out.printf("Mul result: %d * %d = %d\n", result.getN1(),
          result.getN2(), result.getResult());
//      getContext().stop(getSender());

    } else if (message instanceof Op.DivisionResult) {
      Op.DivisionResult result = (Op.DivisionResult) message;
      System.out.printf("Div result: %.0f / %d = %.2f\n", result.getN1(),
          result.getN2(), result.getResult());
//      getContext().stop(getSender());

    }else if (message instanceof ReceiveTimeout) {
      System.out.println("CreationActor中超时重新请求创建========================");

    } else {
      System.out.println("=================无法处理。。。。");
      unhandled(message);
    }
  }
}
