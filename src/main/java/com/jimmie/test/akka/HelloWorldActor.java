package com.jimmie.test.akka;

import akka.actor.UntypedActor;

public class HelloWorldActor extends UntypedActor
{
    public static void main( String[] args )
    {/*
        //create and start the actor 创建启动Actor
            ActorRef actor = actorOf(HelloWorldActor.class).start();
        
        //send the message to the actor and wait for response 发送消息并等待回应
            Object response = actor.ask("Munish").get();
        
            //print the response打印消息
        System.out.println(response);
        
        //stop the actor 停止Actor
        actor.stop();
    */}

        @Override
        public void onReceive(Object message) throws Exception {                
                //receive and reply to the message received 主要方法接受并回复
//                getContext().tryReply("Hello " + message);
                
        }
}
