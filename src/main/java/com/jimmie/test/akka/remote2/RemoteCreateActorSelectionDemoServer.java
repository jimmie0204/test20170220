package com.jimmie.test.akka.remote2;

import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;  
  
public class RemoteCreateActorSelectionDemoServer {  
  
  
  public static void main(String args[]) {  
    // 不使用默认的配置，而是选择加载选定的remote actor配置  
    final ActorSystem system = ActorSystem.create( "CalculatorWorkerSystem", ConfigFactory.load("akka/remote2/calculator.conf"));  
    // 初始化远程actor  
//    ActorRef actref = system .actorOf(Props.create(CalculatorActor. class ),"CalculatorActor" );  
//    System.out.println(actref.path().toString());
    System. out.println( "Started CalculatorWorkerSystem" );  
  
  }  
}  