package com.jimmie.test.线程.线程池;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
 
public class ScheduledThreadPoolExecutorDemo {
	public static AtomicInteger num = new AtomicInteger(0);
    static class TimerTask implements Runnable{
        private String id;
        public TimerTask(String id){
            this.id = id;
        }
        @Override
        public void run(){
        	int incrementAndGet = num.incrementAndGet();
        	System.out.println(incrementAndGet+"=="+Thread.currentThread().getName());
        	if(num .get()==3){
        		try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        	System.out.println(id+"==="+num.get()+"=="+Thread.currentThread().getName());
        }
    }
     
    public static void main(String[] args) throws InterruptedException{
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(5);
        ScheduledFuture sfa = ses.scheduleAtFixedRate(new TimerTask("a"), 200,
                                                    1000, TimeUnit.MILLISECONDS);
//        ScheduledFuture sfb = ses.scheduleAtFixedRate(new TimerTask("b"), 400, 
//                                                    1000, TimeUnit.MILLISECONDS);
//        ScheduledFuture sfc = ses.scheduleAtFixedRate(new TimerTask("c"), 600,
//                                                    1000, TimeUnit.MILLISECONDS);
//        ScheduledFuture sfd = ses.scheduleAtFixedRate(new TimerTask("d"), 800, 
//                                                    1000, TimeUnit.MILLISECONDS);
//        Thread.sleep(5000);
//        sfa.cancel(true);
        Thread.sleep(50000);
        ses.shutdown();
    }
}