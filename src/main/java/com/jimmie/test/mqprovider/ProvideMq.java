package com.jimmie.test.mqprovider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

import javax.annotation.Resource;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ProvideMq {

	@Resource(name="amqpTemplate")
    AmqpTemplate amqpTemplate;
	
	public ProvideMq(){
		System.out.println("create mqProvider...");
	}
	
	public static String print(File file){
		StringBuffer sb = new StringBuffer();
		BufferedReader bf = null;
		String ch = null;
		try {
			bf = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			while((ch=bf.readLine())!=null){
				sb.append(ch);
			}
		} catch (Exception e) {
			try {
				bf.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return sb.toString();
		
	}
	
	public static String print(InputStream i){
		StringBuffer sb = new StringBuffer();
		BufferedReader bf = null;
		String ch = null;
		try {
			bf = new BufferedReader(new InputStreamReader(i));
			while((ch=bf.readLine())!=null){
				sb.append(ch);
			}
		} catch (Exception e) {
			try {
				bf.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return sb.toString();
		
	}

    public void sendMessage() throws URISyntaxException{
    	InputStream in = ClassLoader.getSystemResourceAsStream("com/jimmie/test/mqprovider/json.txt");
    	String message = print(in);
    	try {
    		  amqpTemplate.convertAndSend("fms_return_queue",message);
		} catch (Exception e) {
			e.printStackTrace();
		}
      
        System.out.println("mq send success!!");
    }
    
    public static void main(String[] args) throws URISyntaxException {
    	InputStream in = ClassLoader.getSystemResourceAsStream("com/jimmie/test/mqprovider/json.txt");
    	String message = print(in);
    	System.out.println(message);
		ApplicationContext act = new ClassPathXmlApplicationContext(
				"classpath*:/com/jimmie/test/mqprovider/spring-config-rabbitmq-provider.xml");
    	
    	ProvideMq mq = (ProvideMq)act.getBean("provideMq");
    	mq.sendMessage();
	}
}
