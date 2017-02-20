package com.jimmie.test.文件目录获取.path1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Print {

	public static String print(File file){
		StringBuffer sb = new StringBuffer();
		BufferedReader bf = null;
		String ch = null;
		try {
			bf = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			while((ch=bf.readLine())!=null){
				sb.append(ch);
			}
		} catch (Exception e) {
			try {
				bf.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return sb.toString();
		
	}
	
	public static String print(InputStream i){
		StringBuffer sb = new StringBuffer();
		BufferedReader bf = null;
		String ch = null;
		try {
			bf = new BufferedReader(new InputStreamReader(i));
			while((ch=bf.readLine())!=null){
				sb.append(ch);
			}
		} catch (Exception e) {
			try {
				bf.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return sb.toString();
		
	}
}
