package com.jimmie.test.akka.future;

import java.util.concurrent.TimeUnit;

import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.PoisonPill;
import akka.actor.Props;
import akka.pattern.Patterns;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

/**
 * Created by liubenlong on 2017/1/16.
 */
public class AskMain {

    public static void main(String[] args) throws Exception {
        ActorSystem system = ActorSystem.create("strategy", ConfigFactory.load("akka.config"));
        ActorRef printActor = system.actorOf(Props.create(PrintActor.class), "PrintActor");
        ActorRef workerActor = system.actorOf(Props.create(WorkerActor.class), "WorkerActor");

        
        //等等future返回
        Future<Object> future = Patterns.ask(workerActor, 5, 5000);
        System.out.println("消息发送完毕==");
        int result = (int) Await.result(future, Duration.create(5, TimeUnit.SECONDS));
        System.out.println("result:" + result);

        //不等待返回值，直接重定向到其他actor，有返回值来的时候将会重定向到printActor
//        Future<Object> future1 = Patterns.ask(workerActor, 8, 5000);
//        System.out.println("消息发送完毕==");
//		Patterns.pipe(future1, system.dispatcher()).to(printActor);

        
        workerActor.tell(PoisonPill.getInstance(), ActorRef.noSender());
        System.out.println("over==========:" + workerActor);
    }
}