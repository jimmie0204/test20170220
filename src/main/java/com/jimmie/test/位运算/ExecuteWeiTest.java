package com.jimmie.test.位运算;

import org.junit.Test;

public class ExecuteWeiTest {
	   private static final int COUNT_BITS = Integer.SIZE - 30;
	    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

	    // runState is stored in the high-order bits
	    private static final int RUNNING    = -1 << COUNT_BITS;
	    private static final int SHUTDOWN   =  0 << COUNT_BITS;
	    private static final int STOP       =  1 << COUNT_BITS;
	    private static final int TIDYING    =  2 << COUNT_BITS;
	    
	    private static int runStateOf(int c)     { return c & ~CAPACITY; }
	    private static int workerCountOf(int c)  { return c & CAPACITY; }
	    private static int ctlOf(int rs, int wc) { return rs | wc; }
	    
	    
	   @Test
	   public void test(){
		   System.out.println(Integer.toBinaryString(RUNNING));
		   System.out.println(Integer.toBinaryString(SHUTDOWN));
		   System.out.println(Integer.toBinaryString(STOP));
		   System.out.println(Integer.toBinaryString(TIDYING));

		   System.out.println(Integer.toBinaryString(CAPACITY));
		   System.out.println(Integer.toBinaryString(~CAPACITY));
		   System.out.println(runStateOf(3));
	   }
}
