package com.jimmie.test.akka.消息可变性;

import java.io.IOException;

import com.jimmie.test.bean操作.Student;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * 测试消息的不可变性
 * @author Administrator
 *
 */
public class MasterActor extends UntypedActor{

	@Override
	public void onReceive(Object arg0) throws Exception {
		
		System.out.println(arg0);
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		ActorSystem system = ActorSystem.create("jimmie");
		
		ActorRef helloworker = system.actorOf(Props.create(HelloWorker.class), "helloworker");
		
		final Student s = new Student(12, "sss");
		helloworker.tell(s,ActorRef.noSender());
//		Thread.sleep(2000);
//		s.setAge(34);//收到的消息改变，符合java对象引用传递
		System.in.read();
	}

}
