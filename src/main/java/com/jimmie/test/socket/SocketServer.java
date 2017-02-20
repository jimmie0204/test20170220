package com.jimmie.test.socket;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	
	public byte[] getByte(String line) {
		byte[] bt = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream objos = null;
		try {
			if (line != null) {
				objos = new ObjectOutputStream(baos);
				objos.writeObject(line);
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

	
	

	public static void main(String[] args) throws IOException {
		SocketServer ss = new SocketServer();
		
		ServerSocket server = new ServerSocket(8080);
		
		Socket socket = null;
		DataInputStream bin = null ;
		FileOutputStream fo = null ;
		
		try {
			
			socket = server.accept();
			InputStream in = socket.getInputStream();
			bin =new DataInputStream( new BufferedInputStream(in));
			
			
			fo = new FileOutputStream(new File("aaa.txt"));
				
			String line = bin.readLine();		
			while( line!= null){
				fo.write(ss.getByte(line));
				line =  bin.readLine();		
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			fo.close();
			bin.close();
			socket.close();
			server.close();
		}
		
		
		
		
		
		
		
	}

}
