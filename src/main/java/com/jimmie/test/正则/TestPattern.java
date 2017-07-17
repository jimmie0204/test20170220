package com.jimmie.test.正则;

import java.util.Map;
import java.util.regex.Matcher;

import org.apache.commons.lang.StringUtils;
import org.apache.oro.text.regex.MalformedPatternException;
import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.PatternCompiler;
import org.apache.oro.text.regex.PatternMatcher;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;
import org.junit.Test;

import com.google.common.collect.MapMaker;

public class TestPattern {

	  public static final String          MODE_PATTERN = "(.*)(\\[(\\d+)\\-(\\d+)\\])(.*)"; // 匹配offer[1-128]
	    private static Map<String, Pattern> patterns     = new MapMaker().makeMap();/*new Function<String, Pattern>() {

	                                                         public Pattern apply(String input) {
	                                                             PatternCompiler pc = new Perl5Compiler();
	                                                             try {
	                                                                 return pc.compile(input,
	                                                                     Perl5Compiler.CASE_INSENSITIVE_MASK
	                                                                             | Perl5Compiler.READ_ONLY_MASK);
	                                                             } catch (MalformedPatternException e) {
	                                                                 
	                                                             }
																return null;
	                                                         }
	                                                     });*/
	    
	    private static boolean isWildCard(String value) {
	        return StringUtils.containsAny(value, new char[] { '*', '?', '+', '|', '(', ')', '{', '}', '[', ']', '\\', '$','^', '.' });
	    }
	    
	
	    
		
		public static String makeSQLPattern(String schema) {
			String ll = StringUtils.substringBefore(schema, "[") + "%";

		System.out.println(ll);
		return ll;
		}
		
		public static String makeSQLPattern2(String schema) {
			  StringBuilder sb = new StringBuilder(schema.length());
	          FOR_LOOP: for (int i = 0; i < schema.length(); i++) {
	              String charString = String.valueOf(schema.charAt(i));
	              if (isWildCard(charString)) {
	                  break FOR_LOOP;
	              } else {
	                  sb.append(schema.charAt(i));
	              }
	          }
	          return sb.toString() + "%";
		}
		
		
		
	    /**
	     * 解析DataMedia中的namespace和name，支持offer[1-128]分库的定义
	     */
	    public static void parseMode(String value) {
	        PatternMatcher matcher = new Perl5Matcher();
	        /*if (matcher.matches(value, patterns.get(MODE_PATTERN))) {
	            MatchResult matchResult = matcher.getMatch();
	            String prefix = matchResult.group(1);
	            String startStr = matchResult.group(3);
	            String ednStr = matchResult.group(4);
	            int start = Integer.valueOf(startStr);
	            int end = Integer.valueOf(ednStr);
	            String postfix = matchResult.group(5);

	            List<String> values = new ArrayList<String>();
	            for (int i = start; i <= end; i++) {
	                StringBuilder builder = new StringBuilder(value.length());
	                String str = String.valueOf(i);
	                // 处理0001类型
	                if (startStr.length() == ednStr.length() && startStr.startsWith("0")) {
	                    str = StringUtils.leftPad(String.valueOf(i), startStr.length(), '0');
	                }

	                builder.append(prefix).append(str).append(postfix);
	                values.add(builder.toString());
	            }
	        } else */if (isWildCard(value)) {// 通配符支持
	        	System.out.println("通配符匹配");
	        } else {
	        	System.out.println("single 匹配");
	        }
	    }
	    
	    private static boolean isWildCardMatch(String matchPattern, String value) {
	        PatternMatcher matcher = new Perl5Matcher();
	        return matcher.matches(value, patterns.get(matchPattern));
	    }
	    
	    
	    public Pattern apply(String input) {
            PatternCompiler pc = new Perl5Compiler();
            try {
                return pc.compile(input,
                    Perl5Compiler.CASE_INSENSITIVE_MASK
                            | Perl5Compiler.READ_ONLY_MASK);
            } catch (MalformedPatternException e) {
                
            }
			return null;
        }
	    
	    
	    
		public static boolean match(String str,String regEx){
			regEx = MODE_PATTERN;
		    // 编译正则表达式
			java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regEx);
		    // 忽略大小写的写法
		    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		    Matcher matcher = pattern.matcher(str);
		    // 字符串是否与正则表达式相匹配
		    boolean rs = matcher.matches();
		    System.out.println(rs);
			return rs;
		}
		
		
	@Test
	public void test1(){
		
		parseMode("tes[t");
		String ll = makeSQLPattern2("tes[t");
		isWildCardMatch("tes[t","test");
	}
	
	@Test
	public void test2(){
		String str = "accoun%";
//		String str = "tes[t";
		parseMode("accoun%");
		String ll = makeSQLPattern2("tes[t");
		isWildCardMatch("tes[t","test");
	}
	
	@Test
	public void test3(){
		String str = "accoun%";
		match(str, null);
	}
	
	@Test
	public void test4(){
		parseMode("*");
	}
}
