package com.jimmie.test.序列化.fastSerialize;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;
import org.objenesis.strategy.StdInstantiatorStrategy;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public class KyroSerializableMore {  
      
    public static void main(String[] args) throws IOException {  
        long start =  System.currentTimeMillis();  
        setSerializableObject();  
        System.out.println("Kryo 序列化时间:" + (System.currentTimeMillis() - start) + " ms" );  
        start =  System.currentTimeMillis();  
        getSerializableObject();  
        System.out.println("Kryo 反序列化时间:" + (System.currentTimeMillis() - start) + " ms");  
  
    }  
    
    @Test
    public void encode()  throws IOException, ClassNotFoundException {
    	long start =  System.currentTimeMillis();  
    	  setSerializableObject();  
          System.out.println("Kryo 序列化时间:" + (System.currentTimeMillis() - start) + " ms" );    
    }
    
    @Test
    public void decode(){
    	long start =  System.currentTimeMillis();  
         getSerializableObject();  
         System.out.println("Kryo 反序列化时间:" + (System.currentTimeMillis() - start) + " ms");  
    }
  
    public static void setSerializableObject() throws FileNotFoundException{  
  
        Kryo kryo = new Kryo();  
        kryo.setReferences(false);  
        kryo.setRegistrationRequired(false);  
        kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());  
        kryo.register(MoreSimple.class);  
        Output output = new Output(new FileOutputStream("D:/fileMore1.bin"));  
        for (int i = 0; i < 1; i++) {  
            kryo.writeObject(output, new MoreSimple("zhang"+i,(i+1)));  
        }  
        output.flush();  
        output.close();  
    }  
  
  
    public static void getSerializableObject(){  
        Kryo kryo = new Kryo();  
        kryo.setReferences(false);  
        kryo.setRegistrationRequired(false);  
        kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());  
        Input input;  
        try {  
            input = new Input(new FileInputStream("D:/fileMore1.bin"));  
            MoreSimple simple =null;  
            while((simple=kryo.readObject(input, MoreSimple.class)) != null){  
                System.out.println(simple.getAge() + "  " + simple.getName() );  
            }  
  
            input.close();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch(KryoException e){  
        	e.printStackTrace();
        }  
    }  
  
}  