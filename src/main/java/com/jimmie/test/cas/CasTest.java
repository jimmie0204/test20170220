package com.jimmie.test.cas;

import sun.misc.Unsafe;

public class CasTest {

    private static final Unsafe unsafe = Unsafe.getUnsafe();
    

    
    private static final long valueOffset;

    static {
      try {
        valueOffset = unsafe.objectFieldOffset
            (CasTest.class.getDeclaredField("value"));
      } catch (Exception ex) { throw new Error(ex); }
    }
    
    private volatile int value;
    
    public static void main(String[] args) {
        unsafe.compareAndSwapInt(CasTest.class, valueOffset, 1, 2);
	}
}
