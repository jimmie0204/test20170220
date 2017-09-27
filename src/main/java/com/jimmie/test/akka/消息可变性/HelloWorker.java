package com.jimmie.test.akka.消息可变性;

import com.jimmie.test.bean操作.Student;

import akka.actor.UntypedActor;
import scala.Option;

public class HelloWorker extends UntypedActor {    //Worker是一个Actor，需要实现onReceive方法
	
	@Override
	public void preStart() throws Exception {
	    System.out.println("HelloWorker创建 context().self()==="+context().self());
	}
	
	@Override
	public void preRestart(Throwable reason, Option<Object> message) throws Exception {
		// TODO Auto-generated method stub
		super.preRestart(reason, message);
		System.out.println("actor 重启。。。。");
	}
    @Override
	public void onReceive(Object o) {
        System.out.println("Worker 收到消息----" + o); 
        if (o instanceof Student) {
        	try {
				Thread.sleep(1000 * 3);
				 System.out.println("Worker 收到消息----" + o); 
				 int i= 1/0;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//        	getSender().tell("result----" + o + " 。", getSelf());
        }
    }
}
