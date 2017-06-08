package com.jimmie.test.时间轮.netty;
import java.util.concurrent.TimeUnit;


public class Main implements TimerTask{
	
    final static Timer timer = new TimerWheel(1,TimeUnit.SECONDS,4);
//    final static Timer timer = new TimerWheel();

    public static void main(String[] args) {
        TimerTask timerTask = new Main();
        for (int i = 0; i < 1; i++) {
//            timer.newTimeout(timerTask, i+1, TimeUnit.SECONDS, "" + i );
            timer.newTimeout(timerTask, 2, TimeUnit.SECONDS, "" + i );
//            timer.newTimeout(timerTask, (i+1)%4, TimeUnit.SECONDS, "" + i );
        }
        System.out.println("所有任务已添加，over");
    }
    @Override
    public void run(Timeout timeout, String argv) throws Exception {
        System.out.println("失效timeout, argv = " + argv );
    }
}
