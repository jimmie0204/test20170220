package com.jimmie.test.序列化.java序列化;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

//使用ObjectInputStream实现对象的反序列化操作   
public class ObjectInputStreamDemo {   

  public static void main(String[] args) throws Exception{   

//      File f=new File("d:"+File.separator+"person.ser");  
	  File f=new File("person.ser");   
      ObjectInputStream ois=new ObjectInputStream(new FileInputStream(f));   
      Car p=(Car)ois.readObject();   
      System.out.println(p.getMake());   

  }   

}  