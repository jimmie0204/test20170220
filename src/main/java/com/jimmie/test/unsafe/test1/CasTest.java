package com.jimmie.test.unsafe.test1;

import sun.misc.Unsafe;

public class CasTest {

	private static final Unsafe unsafe;

	private static final long valueOffset;

	static {
		try {
			unsafe = UnsafeUtil.getUnsafe();
			valueOffset = unsafe.objectFieldOffset(CasTest.class.getDeclaredField("value"));
		} catch (Exception ex) {
			throw new Error(ex);
		}
	}

	private volatile int value;
	
    public boolean compareAndSet(final int expectedValue, final int newValue)
    {
    	System.out.println(value);
        return unsafe.compareAndSwapInt(this, valueOffset, expectedValue, newValue);
    }

	public static void main(String[] args) {
		
		
		CasTest casTest = new CasTest();
		
		boolean result = casTest.compareAndSet(0, 1);
		System.out.println(result);
	}
}
