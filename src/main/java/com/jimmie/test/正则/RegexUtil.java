package com.jimmie.test.正则;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {

	/**
	 * 字母/数字及*-_（）%，描述，最多30个字
	 * @param str
	 * @return
	 */
	public static boolean match1(String str){
		String regEx = "[()\\%\\*A-Za-z0-9_-]{1,30}";
	    // 编译正则表达式
	    Pattern pattern = Pattern.compile(regEx);
	    // 忽略大小写的写法
	    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(str);
	    // 字符串是否与正则表达式相匹配
	    boolean rs = matcher.matches();
		return rs;
	}
	
	/**
	 * 字母/汉字/数字及*-_（）%，描述，最多30个字
	 * @param str
	 * @return
	 */
	public static boolean match1_(String str){
		String regEx = "[()\\%\\*A-Za-z0-9\\u4e00-\\u9fa5_-]{1,30}";
	    // 编译正则表达式
	    Pattern pattern = Pattern.compile(regEx);
	    // 忽略大小写的写法
	    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(str);
	    // 字符串是否与正则表达式相匹配
	    boolean rs = matcher.matches();
		return rs;
	}
	
	/**
	 * 汉字、数字、字母，最多30个字
	 * @param str
	 * @return
	 */
	public static boolean match2(String str){
		String regEx = "[a-zA-Z0-9\\u4e00-\\u9fa5]{1,30}";
	    // 编译正则表达式
	    Pattern pattern = Pattern.compile(regEx);
	    // 忽略大小写的写法
	    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(str);
	    // 字符串是否与正则表达式相匹配
	    boolean rs = matcher.matches();
		return rs;
	}
	
	/**
	 * 正整数
	 * @param str
	 * @return
	 */
	public static boolean matchNum(String str){
		String regEx = "[0-9]+";
	    // 编译正则表达式
	    Pattern pattern = Pattern.compile(regEx);
	    // 忽略大小写的写法
	    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(str);
	    // 字符串是否与正则表达式相匹配
	    boolean rs = matcher.matches();
		return rs;
	}
	
	/**
	 * 汉字、数字、字母，空格，英文逗号
	 * @param str
	 * @return
	 */
	public static boolean match3(String str){
		String regEx = "[\\s+a-zA-Z0-9\\u4e00-\\u9fa5,]+";
	    // 编译正则表达式
	    Pattern pattern = Pattern.compile(regEx);
	    // 忽略大小写的写法
	    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(str);
	    // 字符串是否与正则表达式相匹配
	    boolean rs = matcher.matches();
		return rs;
	}
	
	/**
	 * 判断yyyy-MM-dd hh:mm:ss格式 \\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{2}:\\d{2}:\\d{2}
	 * \\d{4}-\\d{1,2}-\\d{1,2} 是判断yyyy-MM-dd格式
	 * @param str
	 * @return
	 */
	public static boolean matchDate(String str){
		String regEx = "\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{2}:\\d{2}:\\d{2}";
	    // 编译正则表达式
	    Pattern pattern = Pattern.compile(regEx);
	    // 忽略大小写的写法
	    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(str);
	    // 字符串是否与正则表达式相匹配
	    boolean rs = matcher.matches();
		return rs;
	}
	
	public static void main(String[] args) {
		System.out.println(RegexUtil.match3(""));;
	}
}
