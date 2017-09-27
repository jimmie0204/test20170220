package com.jimmie.test.akka.remote.client;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pie.jimmie.util.LogBackConfigLoader;

import ch.qos.logback.core.joran.spi.JoranException;

public class Test {
	public static void main(String[] args) throws IOException, JoranException {
		LogBackConfigLoader.load("D:/WorkSpaces6/test20170220/target/classes/logback.xml");  
		ApplicationContext act = new ClassPathXmlApplicationContext(
				"com/jimmie/test/akka/remote/client/spring.xml");
		
		ClientStarter bean =(ClientStarter) act.getBean("clientStarter");
		try {
			bean.start();
			System.in.read();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
