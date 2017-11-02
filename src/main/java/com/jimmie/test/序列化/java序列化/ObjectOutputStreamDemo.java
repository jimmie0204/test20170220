package com.jimmie.test.序列化.java序列化;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

//使用ObjectOutputStream实现对象的序列化操作  
public class ObjectOutputStreamDemo {

	public static void main(String []args) throws Exception{   
        
        File f=new File("person.ser");//文件存放位置   
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(f));   
        Car p=new Car("雅各布",22);   
        oos.writeObject(p);   
        oos.close();   
    }   
}
