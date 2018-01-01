package com.jimmie.test.akka.remote2;

import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;  
  
public class RemoteCreateActorSelectionDemo {  
  
  public static class HandlerResult extends UntypedActor {  
  
    @Override  
    public void preStart() throws Exception {  
//      ActorSelection selection = this .getContext().actorSelection("akka.tcp://CalculatorWorkerSystem@127.0.0.1:2552/user/CalculatorActor" );  
//    	System. out .println("selection : " + selection.pathString() );  
//    	selection.tell( new Op.Add(1, 2), this.getSelf());  
    	
      ActorRef sampleActor = getContext().actorOf(Props.create(CalculatorActor.class));
      System. out .println("sampleActor : " + sampleActor.path().toString() );  
      sampleActor.tell( new Op.Add(1, 2), this.getSelf());  
    }  
  
  
    @Override  
    public void onReceive(Object message ) throws Exception {  
      if ( message instanceof Op.AddResult) {  
        System. out .println("add result=" + ((Op.AddResult) message ).getResult());  
      } else if (message instanceof Op.SubtractResult) {  
        System. out .println("subtract result=" + ((Op.SubtractResult) message ).getResult());  
      } else if (message instanceof Op.MultiplicationResult) {  
        System. out .println("multiply result=" + ((Op.MultiplicationResult) message ).getResult());  
      } else if (message instanceof Op.DivisionResult) {  
        System. out .println("divide result=" + ((Op.DivisionResult) message ).getResult());  
      }  
    }  
  }  
  
  public static void main(String args[]) {  
//    // 不使用默认的配置，而是选择加载选定的remote actor配置  
//    final ActorSystem system = ActorSystem.create( "CalculatorWorkerSystem", ConfigFactory.load("akka/remote2/calculator.conf"));  
//    // 初始化远程actor  
//    ActorRef actref = system .actorOf(Props.create(CalculatorActor. class ),"CalculatorActor" );  
//    System.out.println(actref.path().toString());
//    System. out.println( "Started CalculatorWorkerSystem" );  
  
    // 初始化本地的Actor  
    final ActorSystem localSystem = ActorSystem.create( "localSystem", ConfigFactory.load(( "akka/remote2/remotelookup.conf")));  
    localSystem .actorOf(Props.create(HandlerResult. class ), "sampleActor" );  
  
  }  
}  