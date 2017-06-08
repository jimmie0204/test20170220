package com.jimmie.test.时间轮;

public interface ExpirationListener<E> {

	/** 
     * Invoking when a expired event occurs. 
     *  
     * @param expiredObject 
     */  
    void expired(E expiredObject); 
}
