package com.jimmie.test.unsafe.test2;

import sun.misc.Unsafe;

public class MyUnSafeTest {

	private static final Unsafe unsafe;

	private static final long valueOffset;

	static {
		try {
			unsafe = getUnsafe();
			valueOffset = unsafe.objectFieldOffset(MyUnSafeTest.class.getDeclaredField("value"));
		} catch (Exception ex) {
			throw new Error(ex);
		}
	}

	private volatile int value;
	
    public int get()
    {
        return value;
    }
	
    private static sun.misc.Unsafe getUnsafe() {
        try {
            return sun.misc.Unsafe.getUnsafe();
        } catch (SecurityException tryReflectionInstead) {}
        try {
            return java.security.AccessController.doPrivileged
            (new java.security.PrivilegedExceptionAction<sun.misc.Unsafe>() {
                public sun.misc.Unsafe run() throws Exception {
                    Class<sun.misc.Unsafe> k = sun.misc.Unsafe.class;
                    for (java.lang.reflect.Field f : k.getDeclaredFields()) {
                        f.setAccessible(true);
                        Object x = f.get(null);
                        if (k.isInstance(x))
                            return k.cast(x);
                    }
                    throw new NoSuchFieldError("the Unsafe");
                }});
        } catch (java.security.PrivilegedActionException e) {
            throw new RuntimeException("Could not initialize intrinsics",
                                       e.getCause());
        }
    }
	
    public boolean compareAndSet(final int expectedValue, final int newValue)
    {
    	System.out.println(Thread.currentThread().getName()+"=========="+value);
        return unsafe.compareAndSwapInt(this, valueOffset, expectedValue, newValue);
    }

	public static void main(String[] args) {
		
		
		MyUnSafeTest casTest = new MyUnSafeTest();
		
		boolean result = casTest.compareAndSet(0, 1);
		System.out.println(result);
	}
}
