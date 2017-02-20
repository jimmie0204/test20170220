package com.jimmie.test.socket;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class JavaTest {

	public static void main(String args[]) {
		JavaTest jt = new JavaTest();

		String s = "helloworld!";
		byte[] bt = null;
		/*bt = s.getBytes();
		ArrayList<String> list = new ArrayList<String>();
		list = jt.getArrayList(bt);// 这一行会出错。
*/		
		ArrayList<String> list = new ArrayList<String>();

		ArrayList<String> byte_list= new ArrayList<String>();

		byte_list.add(s);

		bt=jt.getByte(byte_list);//通过调用getByte()方法得到bt[]数组。
		list=jt.getArrayList(bt);

	}

	public ArrayList<String> getArrayList(byte[] bt) {
		ArrayList<String> list = new ArrayList<String>();
		ObjectInputStream objIps;

		// 注意这里，ObjectInputStream 对以前使用 ObjectOutputStream
		// 写入的基本数据和对象进行反序列化。问题就在这里，你是直接将byte[]数组传递过来
		//，而这个byte数组不是使用ObjectOutputStream类写入的。所以问题解决的办法就是：用输出流得到byte[]数组。
		try {
			objIps = new ObjectInputStream(new ByteArrayInputStream(bt));
			list = (ArrayList<String>) objIps.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public byte[] getByte(ArrayList<String> list) {
		byte[] bt = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream objos = null;
		try {
			if (list != null) {
				objos = new ObjectOutputStream(baos);
				objos.writeObject(list);
				bt = baos.toByteArray();
				
			}
		} catch (Exception e) {
			bt = (byte[]) null;
			e.printStackTrace();

		}finally{
			try {
				objos.close();
				baos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bt;
	}

}