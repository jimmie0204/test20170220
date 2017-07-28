package com.jimmie.test.序列化.fastSerialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

/**
 * hessian serialize 加减字段没问题

 */
public class HessianSerializer  {

	public static <T> byte[] serialize(T obj){
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		HessianOutput ho = new HessianOutput(os);
		try {
			ho.writeObject(obj);
		} catch (IOException e) {
			throw new IllegalStateException(e.getMessage(), e);
		}
		return os.toByteArray();
	}

	public static <T> Object deserialize(byte[] bytes, Class<T> clazz) {
		ByteArrayInputStream is = new ByteArrayInputStream(bytes);
		HessianInput hi = new HessianInput(is);
		try {
			return hi.readObject();
		} catch (IOException e) {
			throw new IllegalStateException(e.getMessage(), e);
		}
	}
	
	   @Test
	    public void encode()  throws Exception {
	    	long start =  System.currentTimeMillis();  
	    	  setSerializableObject();  
	          System.out.println("Kryo 序列化时间:" + (System.currentTimeMillis() - start) + " ms" );    
	    }
	    
	    private void setSerializableObject() throws Exception{
	        FileOutputStream fo = new FileOutputStream("D:/fileMore.bin");  
	        
	        ObjectOutputStream so = new ObjectOutputStream(fo);  
	        
	        HessianOutput ho = new HessianOutput(so);
	        ho.writeObject(new MoreSimple("sdsd",1));
	        ho.close();
	        
	        System.out.println("se===end");
	}

		@Test
	    public void decode() throws Exception{
	    	long start =  System.currentTimeMillis();  
	         getSerializableObject();  
	         System.out.println("Kryo 反序列化时间:" + (System.currentTimeMillis() - start) + " ms");  
	    }

		private void getSerializableObject() throws Exception {
			FileInputStream fi = new FileInputStream("D:/fileMore.bin");  
	       ObjectInputStream si = new ObjectInputStream(fi);  
	       HessianInput hi = new HessianInput(si);
	       MoreSimple readObject = (MoreSimple)hi.readObject();
	       System.out.println(readObject.getName());
		}
	
}
