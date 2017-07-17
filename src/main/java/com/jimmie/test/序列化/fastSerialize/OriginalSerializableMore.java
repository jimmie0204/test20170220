package com.jimmie.test.序列化.fastSerialize;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class OriginalSerializableMore {  
      
    public static void main(String[] args) throws IOException, ClassNotFoundException {  
        long start =  System.currentTimeMillis();  
        setSerializableObject();  
        System.out.println("java原生序列化时间:" + (System.currentTimeMillis() - start) + " ms" );    
       
    }  
    
    @Test
    public void encode()  throws IOException, ClassNotFoundException {
    	long start =  System.currentTimeMillis();  
    	  setSerializableObject();  
          System.out.println("java原生序列化时间:" + (System.currentTimeMillis() - start) + " ms" );    
    }
    
    @Test
    public void decode(){
    	long start =  System.currentTimeMillis();  
         getSerializableObject();  
         System.out.println("java原生反序列化时间:" + (System.currentTimeMillis() - start) + " ms");  
    }
  
    public static void setSerializableObject() throws IOException{  
  
        FileOutputStream fo = new FileOutputStream("D:/fileMore.bin");  
  
        ObjectOutputStream so = new ObjectOutputStream(fo);  
  
        for (int i = 0; i < 1; i++) {  
            so.writeObject(new MoreSimple("zhang"+i,(i+1)));  
        }  
        so.flush();  
        so.close();  
    }  
  
    public static void getSerializableObject(){  
         FileInputStream fi;  
        try {  
            fi = new FileInputStream("D:/fileMore.bin");  
            ObjectInputStream si = new ObjectInputStream(fi);  
  
            MoreSimple simple =null;  
            while((simple=(MoreSimple)si.readObject()) != null){  
                System.out.println(simple.getAge() + "  " + simple.getName());  
            }  
            fi.close();  
            si.close();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            //e.printStackTrace();  
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        }  

    }  
  
}  