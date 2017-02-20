package com.jimmie.test.正则;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class PatternTest {

	@Test
	public void test(){
		  // 要验证的字符串
	    String str = "service@xsoftlab.net";
	    // 邮箱验证规则
	    String regEx = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
	    // 编译正则表达式
	    Pattern pattern = Pattern.compile(regEx);
	    // 忽略大小写的写法
	    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(str);
	    // 字符串是否与正则表达式相匹配
	    boolean rs = matcher.matches();
	    System.out.println(rs);
	}
	
	public static boolean func(String str,String regEx){
	    // 编译正则表达式
	    Pattern pattern = Pattern.compile(regEx);
	    // 忽略大小写的写法
	    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(str);
	    // 字符串是否与正则表达式相匹配
	    boolean rs = matcher.matches();
	    System.out.println(rs);
		return rs;
	}
	
	public static String escapeExprSpecialWord(String keyword) {  
	    if (StringUtils.isNotBlank(keyword)) {  
//	        String[] fbsArr = { "\\", "$", "(", ")", "*", "+", ".", "[", "]", "?", "^", "{", "}", "|" }; 
	    	String[] fbsArr = { "(", ")", "*"}; 
	        for (String key : fbsArr) {  
	            if (keyword.contains(key)) {  
	                keyword = keyword.replace(key, "\\" + key);  
	            }  
	        }  
	    }  
	    return keyword;  
	}  

	@Test
	public void test2(){
		String str = "2 2%-sd*-sds)d-44 (";
		
		String regex = "[\\s+()\\%\\*A-Za-z1-9_-]{1,30}";
//		regex =escapeExprSpecialWord(regex);
		System.out.println(regex);
		func(str,regex);
	}
	
	@Test
	public void test4(){
		String str = "sd， sdsd,sd";
		
		String regEx = "[\\s+a-zA-Z0-9\\u4e00-\\u9fa5,]+";
//		regex =escapeExprSpecialWord(regex);
		System.out.println(regEx);
		func(str,regEx);
	}
	
	@Test
	public void test5(){
		String str = "2016-12-22 12:10:01";
		
		String regEx = "\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{2}:\\d{2}:\\d{2}";
//		regex =escapeExprSpecialWord(regex);
		System.out.println(regEx);
		func(str,regEx);
	}
	
	
	
	@Test
	public void test3(){
		
		String regex = "22.00";
		regex.matches("[0-9]+");
//		System.out.println(Integer.valueOf(regex));
		System.out.println(regex.matches("[0-9]+"));
		
	}
	
	

	
	/**
	 * 多数据项英文逗号分隔
	 */
	private static String[] split(String s){
		String[] split = s.split(",");
		System.out.println(split.length);
		return split;
	}
	
	public static void main(String[] args) {
		
		StringBuffer errorMsgBuffer = new StringBuffer("sdsdsd,");
		String ss = errorMsgBuffer.toString();
		int ll= ss.length();
		if(ll!=0){
			ss=ss.substring(0, ll-1);
		}
		
		System.out.println(ll+"==="+ss);
	}
}
