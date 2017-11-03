package com.jimmie.test.日志;

import java.io.IOException;

//import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pie.jimmie.util.LogBackConfigLoader;

import ch.qos.logback.core.joran.spi.JoranException;


public class LogA {

	//还可以这样
	/*static {
        try {
        	org.springframework.util.Log4jConfigurer.initLogging("classpath:log4j.properties");
        } catch (FileNotFoundException ex) {
            System.err.println("Cannot Initialize log4j");
            System.exit(-1);
        }
    }*/
	public static Logger log = LoggerFactory.getLogger("jj");
	
	public void hh(MyInter myInter){
		myInter.doSth(new Tiger());
	}
	public static void main(String[] args) throws IOException, JoranException {
//		BasicConfigurator.configure();//没有配置文件的
//		PropertyConfigurator.configure(LogA.class.getResourceAsStream("../log4j.properties"));//使用log4j.properties文件
		 LogBackConfigLoader.load("D:/WorkSpaces6/test20170220/target/classes/logback.xml");  //logback使用
//		DOMConfigurator.configure(LogA.class.getResource("../log4j.xml"));//log4j使用xml文件
		log.info("我是logA的main方法打出的日志。。。");
		MyImp imp = new MyImp();
		
		new LogA().hh(imp);
		
		System.out.println(LogA.class.getName());
		log.info("{} is {}", "x");
		log.info("商品在as中的逻辑id为{},商品sku为{},在bms中存在，在bms中逻辑id为{},执行更新",new Object[]{111,"ssdfsg",333});
	}
}
