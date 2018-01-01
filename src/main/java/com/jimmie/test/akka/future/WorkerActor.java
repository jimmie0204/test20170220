package com.jimmie.test.akka.future;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * Created by liubenlong on 2017/1/12.
 */
public class WorkerActor extends UntypedActor {

    private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);
    
    @Override
    public void postStop() throws Exception {
    	System.out.println("stop WorkerActor...");
    	super.postStop();
    }

    @Override
    public void onReceive(Object o) throws InterruptedException {
        log.info("akka.future.WorkerActor.onReceive:" + o);

        if (o instanceof Integer) {
        	System.out.println(Thread.currentThread().getName()+"=1="+sender().hashCode());
            Thread.sleep(2500);
            System.out.println(Thread.currentThread().getName()+"=2="+sender().hashCode());
            int i = Integer.parseInt(o.toString());
            getSender().tell(i*i, getSelf());
        } else {
            unhandled(o);
        }
    }

}