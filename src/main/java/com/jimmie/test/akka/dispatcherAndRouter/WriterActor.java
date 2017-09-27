package com.jimmie.test.akka.dispatcherAndRouter;

import akka.actor.UntypedActor;

public class WriterActor extends UntypedActor {
    @Override
    public void onReceive(Object message) throws Exception {
        System.out.println(Thread.currentThread().getName()+"=="+sender().hashCode());
    }
}