package com.jimmie.test.线程.end;

	 public class ThreadA extends Thread {
	    private boolean isRunning=true;
	   int count=0;
	   public void interrupt(){
		   isRunning = false;
//	       super.interrupt();
	      }
	   
	   public void run(){
	       System.out.println(getName()+"将要运行...");
	       while(isRunning){
	           System.out.println(getName()+"运行中"+count++);
	           try{
	               Thread.sleep(2000);
	           }catch(InterruptedException e){
	               System.out.println(getName()+"从阻塞中退出...");
	               System.out.println("this.isInterrupted()="+this.isInterrupted());
	           }
	       }
	       System.out.println(getName()+"已经终止!");
	   }

}
