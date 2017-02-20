package com.jimmie.test.文件目录获取.path1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

import org.junit.Test;

public class TestMain {

	public static void print(InputStream i){
		
		BufferedReader bf = null;
		String ch = null;
		try {
			bf = new BufferedReader(new InputStreamReader(i));
			while((ch=bf.readLine())!=null){
				System.out.print(ch);
			}
			System.out.println();
		} catch (Exception e) {
			try {
				bf.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	public static void print(File file){
		
		BufferedReader bf = null;
		String ch = null;
		try {
			bf = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			while((ch=bf.readLine())!=null){
				System.out.print(ch);
			}
			System.out.println();
		} catch (Exception e) {
			try {
				bf.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	//Class的getResource()方法是从当前.class 文件路径查找资源,ClassLoader则是从jar包根目录查找.
	//用ClassLoader加载配置文件时，pathToConfigFile均不能以"/"开头，在查找时直接在classpath下进行查找。
	@Test
	public void classWay1() throws FileNotFoundException, URISyntaxException{
		URL url = TestMain.class.getResource("../aa.txt");
		URL url2 = TestMain.class.getResource("bb.txt");
		URL url3 = TestMain.class.getResource("../path2/cc.txt");
		System.out.println(url);
		System.out.println(url2);
		System.out.println(url3);
		
		FileInputStream fin = new FileInputStream(new File(url3.toURI()));
		print(fin);
		print(new File(url3.toURI()));
	}
	
	@Test
	public void classWay2(){
		InputStream in = TestMain.class.getResourceAsStream("../aa.txt");
		InputStream in2 = TestMain.class.getResourceAsStream("../path2/cc.txt");
		print(in);
		print(in2);
	}
	
	@Test
	public void loadWay3(){
		URL url4 = TestMain.class.getClassLoader().getResource("com/jimmie/test/文件目录获取/path1/bb.txt");
		System.out.println(url4);
		
	}
	
	@Test
	public void loadWay4(){
		URL url5 = ClassLoader.getSystemResource("com/jimmie/test/文件目录获取/path1/bb.txt");
		System.out.println(url5);
	}
	
	@Test
	public void loadWay5(){
		InputStream in = ClassLoader.getSystemResourceAsStream("com/jimmie/test/文件目录获取/path1/bb.txt");
		print(in);
	}
	
	@Test
	public void testClassLoader(){
		ClassLoader loader = ClassLoader.getSystemClassLoader();
		
		ClassLoader loader2 = Thread.currentThread().getContextClassLoader();
		
		ClassLoader loader3  = Object.class.getClassLoader();
		
		ClassLoader loader4  = ArrayList.class.getClassLoader();
		
		System.out.println(loader);
		System.out.println(loader2);
		System.out.println(loader3);
		System.out.println(loader4);
	}

}
