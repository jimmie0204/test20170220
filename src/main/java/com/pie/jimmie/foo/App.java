package com.pie.jimmie.foo;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.core.joran.spi.JoranException;

/**
 * 
 */
public class App {
	private static Logger LOG = LoggerFactory.getLogger("foopp");
	/**
	 * 
	 */
	public static void print(){
    	LOG.trace("======trace");  
    	LOG.debug("======debug");  
    	LOG.info("======info");  
    	LOG.warn("======warn");  
    	LOG.error("======error");  
	}
	/**
	 * <pre>
	 * @param args
	 * @throws IOException
	 * @throws JoranException
	 */
    /**
     * @param args
     * @throws IOException
     * @throws JoranException
     */
    public static void main(String[] args) throws IOException, JoranException {
    	App.print();
/*    	List<String> list= null;
    	for(String s:list){
    		System.out.println(s);
    	}*/
    }
}
