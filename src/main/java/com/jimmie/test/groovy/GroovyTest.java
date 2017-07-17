package com.jimmie.test.groovy;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

import com.jimmie.test.文件目录获取.path1.Print;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyShell;
import groovy.lang.Script;

public class GroovyTest{
	
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
	
	public static void main(String[] args) throws Exception{
		InputStream in = GroovyTest.class.getResourceAsStream("sd.txt");
		String print = Print.print(in);
		System.out.println(print);
		
		GroovyClassLoader loader = new GroovyClassLoader();
		Class parseClass = loader.parseClass(print);
		System.out.println(parseClass.getName());
	
		
	
		
	}
	
	@Test
	public void test1() throws Exception{
		GroovyClassLoader loader = new GroovyClassLoader();
		Class parseClass2 = loader.parseClass(new File(GroovyTest.class.getResource("sd2.txt").toURI()));
		System.out.println(parseClass2.getName());
	}
	
	@Test
	public void test3() throws Exception{
		GroovyShell shell = new GroovyShell();
		Script groovyScript = shell.parse(new File(GroovyTest.class.getResource("sd2.txt").toURI()));
		Object[] args22 = {};
		groovyScript.invokeMethod("run", args22);
	}
	
}