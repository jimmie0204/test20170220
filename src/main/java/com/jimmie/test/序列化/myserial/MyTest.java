package com.jimmie.test.序列化.myserial;

import java.nio.charset.Charset;

import org.junit.Test;

import io.netty.buffer.ByteBuf;
import io.netty.util.ReferenceCountUtil;

public class MyTest {
	
	
	public static final Charset CHARSET = Charset.forName("UTF-8");

	public static void main(String[] args) {
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setPlayerName("jimmie");
		loginRequest.setPassward("loginRequest");
		byte[] bytes = loginRequest.getBytes();
		
		 System.out.println(bytes.length);  
		  
		LoginRequest loginRequest2 = new LoginRequest();
        loginRequest2.readFromBytes(bytes);
  
        System.out.println(loginRequest2.getPlayerName());  
		
	}
	
	@Test
	public void test1(){
		 String str = "Hello World !";  
		 
		 
		 //序列化
		 ByteBuf writeBuffer = BufferFactory.getBuffer();
		 byte data[] = str.getBytes(CHARSET);
		 System.out.println(data.length);
		 writeBuffer.writeBytes(data);
		 System.out.println(data.length);
		 
		 byte[] bytewr = null;
		 if (writeBuffer.writerIndex() == 0) {
			 bytewr = new byte[0];
		} else {
			bytewr = new byte[writeBuffer.writerIndex()];
			writeBuffer.readBytes(bytewr);
		}
		 writeBuffer.clear();
		//释放buffer
		ReferenceCountUtil.release(writeBuffer);
		 System.out.println(bytewr.length);
		
		 //反序列化(bytewr)
		ByteBuf readBuffer = BufferFactory.getBuffer(bytewr);
		
		byte[] byteread = new byte[bytewr.length];
		readBuffer.readBytes(byteread);
		readBuffer.clear();
		//释放buffer
		ReferenceCountUtil.release(readBuffer);
		String string = new String(byteread, CHARSET);
		System.out.println(string);
		System.out.println(string.length());
	}
	
	@Test
	public void test2(){
		 String str = "Hello World !";  
		
		 
		 Serializer serializer = new Serializer() {
			 
			 private String result = null;
			 
			@Override
			protected void write() {
				writeString(str);
			}
			
			@Override
			protected void read() {
				result = readString();
				System.out.println(result);
			}
			
		};
		
		byte[] bytes = serializer.getBytes();
		System.out.println(bytes.length);
		serializer.readFromBytes(bytes);
	}
	
	@Test
	public void test3(){
		 Integer code = 5;
		
		 
		 Serializer serializer = new Serializer() {
			 
			 private Integer result = null;
			 
			@Override
			protected void write() {
				writeInt(code);
			}
			
			@Override
			protected void read() {
				result = readInt();
				System.out.println(result);
			}
			
		};
		
		byte[] bytes = serializer.getBytes();
		System.out.println(bytes.length);
		serializer.readFromBytes(bytes);
	}
	
	@Test
	public void test4(){
		SS s = new SS();
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setPlayerName("jimmie");
		loginRequest.setPassward("loginRequest");
		s.setLogin(loginRequest);
		s.setCode(24);
		byte[] bytes = loginRequest.getBytes();
		
		 System.out.println(bytes.length);  
		  
		 SS s2 = new SS();
		 s2.readFromBytes(bytes);
		 System.out.println(s2.getCode());  
        System.out.println(s2.getLogin());  
	}
}
