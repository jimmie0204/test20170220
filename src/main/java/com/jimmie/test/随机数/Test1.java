package com.jimmie.test.随机数;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.junit.Test;


public class Test1 {

	public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
			"g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
			"t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
			"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
			"W", "X", "Y", "Z" };
	
	private final static String[] charsNum = new String[] {"0", "1", "2", "3",
		"4", "5", "6", "7", "8", "9"};

	private final static String[] charsNum2 = new String[] {"1", "2", "3",
		"4", "5", "6", "7", "8", "9"};
	
	public static String generateShortUuid() {
/*		StringBuffer shortBuffer = new StringBuffer();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		for (int i = 0; i < 8; i++) {
			String str = uuid.substring(i * 4, i * 4 + 4);
			int x = Integer.parseInt(str, 16);
			shortBuffer.append(chars[x % 0x3E]);
		}
		return shortBuffer.toString();*/
		
		StringBuffer shortBuffer = new StringBuffer();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		for (int i = 0; i < 8; i++) {
			String str = uuid.substring(i * 4, i * 4 + 4);
			int x = Integer.parseInt(str, 16);
			shortBuffer.append(charsNum[x % 10]);
		}
		return shortBuffer.toString();

	}
	
	public static String generateShortUuid2() {
				
				StringBuffer shortBuffer = new StringBuffer();
				String uuid = UUID.randomUUID().toString().replace("-", "");
				String str_ = uuid.substring(0, 4);
				int x_ = Integer.parseInt(str_, 16);
				shortBuffer.append(charsNum2[x_ % 9]);
				
				for (int i = 1; i < 7; i++) {
					String str = uuid.substring(i * 4, i * 4 + 4);
					int x = Integer.parseInt(str, 16);
					shortBuffer.append(charsNum[x % 10]);
				}
				return shortBuffer.toString();

			}

	@Test
	public void test1() {
		System.out.println(UUID.randomUUID().toString().replace("-", "")
				.toUpperCase());
		;
		System.out.println("TZ" + System.currentTimeMillis());
		;
	}

	@Test
	public void test2() {
		System.out.println(Integer.toHexString(64));
		;
	}
	
	@Test
	public void test3() throws IOException{
		
		System.out.println(Runtime.getRuntime().maxMemory()+"===="+Runtime.getRuntime().totalMemory()+"===="+Runtime.getRuntime().freeMemory());
		String before = generateShortUuid();
		String after;
		int count = 0;
		do{
			count++;
			after = generateShortUuid();
//			System.out.println(before+"======="+after);
		}while(!before.equalsIgnoreCase(after)&&count<1000000);
		System.out.println(Runtime.getRuntime().maxMemory()+"===="+Runtime.getRuntime().totalMemory()+"===="+Runtime.getRuntime().freeMemory());
		System.out.println(count);
		System.in.read();		
	}
	
	public static String date2Str(Date date,String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	@Test
	public void test4() {

		System.out.println(date2Str(new Date(),"yyyyMMddHHmmss")+generateShortUuid());;
		

	}
	
	@Test
	public void test5() {

		String uuid = UUID.randomUUID().toString().replace("-", "");
		System.out.println(uuid);
		System.out.println(uuid.length());

	}
	
	@Test
	public void test6() throws IOException{
		
		System.out.println(Runtime.getRuntime().maxMemory()+"===="+Runtime.getRuntime().totalMemory()+"===="+Runtime.getRuntime().freeMemory());
		String after;
		int count = 0;
		Set<String> set = new HashSet<String>();
		do{
			count++;
			after = generateShortUuid2();

			set.add(after);
		}while(count<10000);
		System.out.println(Runtime.getRuntime().maxMemory()+"===="+Runtime.getRuntime().totalMemory()+"===="+Runtime.getRuntime().freeMemory());
		System.out.println(count);
		System.out.println("set大小为："+set.size());
		System.in.read();		
	}
	
	@Test
	public void test7(){
		int strLength = 7;
	 	Random rm = new Random();  
      
	    // 获得随机数  
	    int pross =  (int) ((1 + rm.nextInt()) * Math.pow(10, strLength));  
	  
	    // 将获得的获得随机数转化为字符串  
	    String fixLenthString = String.valueOf(pross);  
	  
	    // 返回固定的长度的随机数  
	    System.out.println(fixLenthString.substring(0, strLength));
		
	}

	@Test
	public void test8(){
		long timenow = System.currentTimeMillis();
	    System.out.println(timenow);
		
	}
	
	public static String random(int length){
		Random rm = new Random();  
		StringBuffer shortBuffer = new StringBuffer(1+rm.nextInt(9));
		for(int i=0;i<length;i++){
			shortBuffer.append(rm.nextInt(10));
		}
		return shortBuffer.toString();
	}
	@Test
	public void test9(){
		Set<String> set = new HashSet<String>();
		for(int i=0;i<1000;i++){
			set.add(random(7));
		}
		System.out.println(set.size());
	}

}
