package com.jimmie.test.akka.spring;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pie.jimmie.util.LogBackConfigLoader;

import ch.qos.logback.core.joran.spi.JoranException;

public class Test {
	public static void main(String[] args) throws IOException, JoranException {
		LogBackConfigLoader.load("D:/WorkSpaces6/test20170220/target/classes/logback.xml");  
		ApplicationContext act = new ClassPathXmlApplicationContext(
				"com/jimmie/test/akka/spring/spring.xml");
		
		CountPrint bean =(CountPrint) act.getBean("countPrint");
		try {
			bean.print();
//			System.in.read();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
