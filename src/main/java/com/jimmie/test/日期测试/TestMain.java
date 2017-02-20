package com.jimmie.test.日期测试;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class TestMain {

	/**取上个月*/
	@Test
	public void test1(){
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar calendar = Calendar.getInstance();
//			Date curDate = java.sql.Date.valueOf("2012-12-22");
			Date curDate = new Date();
			calendar.setTime(curDate);
			//取得现在时间
			System.out.println(sdf.format(curDate));

			//取得上一个时间
			calendar.set(Calendar.MONDAY, calendar.get(Calendar.MONDAY) - 1);

			//取得上一个月的下一天
			calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
			System.out.println(sdf.format(calendar.getTime()));

	}

	/**取本月第一天或最后一天*/
	@Test
	public void test2(){
	Calendar cal = Calendar.getInstance(); 
	  cal.setTime(new Date()); 
	  cal.set(Calendar.DAY_OF_MONTH, 1); 
	  System.out.println (new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime())); 
	  cal.roll(Calendar.DAY_OF_MONTH, -1);  
	  System.out.println (new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
	}

	/**取上月第一天或最后一天*/
	@Test
	public void test3(){
	Calendar cal = Calendar.getInstance(); 
	  cal.setTime(new Date()); 
	  cal.add(Calendar.MONTH, -1);
	  cal.set(Calendar.DAY_OF_MONTH, 1); 
	  System.out.println (new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime())); 
	  cal.roll(Calendar.DAY_OF_MONTH, -1);  
	  System.out.println (new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
	}
	
	@Test
	public void test4(){
		Calendar cal = Calendar.getInstance(); 
		cal.set(2014, 11, 01);//2014-12-01
		Date fDay = cal.getTime();
		System.out.println(fDay);
		cal.clear();
		cal.set(2015,00,01);
		System.out.println(cal.getTime());
	}
	
	@Test
	public void test5(){
		Date date = new Date(0);
		System.out.println(date);
	}
	
	@Test
	public void test6() throws ParseException{
		SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse("2016-08-09 14:12:03");
		System.out.println(date);
	}
	
	@Test
	public void test7(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(1484200797000L); 
		Date date = c.getTime();
		System.out.println(sdf.format(date));
	}

}
