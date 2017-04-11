package com.jimmie.test.谷歌guava;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class FunctionTest {

	@Test
	public void test1(){
		
		ArrayList<String> newArrayList = Lists.newArrayList("sfdsdfg","wwtty","cbnvcm");
		
		Function<String, String> f1 = new Function<String, String>() {

			@Override
			public String apply(String input) {
				
				return "1";
			}
		};
		
		Function<String, String> f2 = new Function<String, String>() {

			@Override
			public String apply(String input) {
				
				return "2";
			}
		};
		
		//先执行f2.apply(),把结果作为f1.apply()的输入
		Function<String, String> compose = Functions.compose(f1, f2);
		
		Collection<String> transform = Collections2.transform(newArrayList, compose);
		
		for(String s:transform){
			System.out.println(s);
		}
		
	}
	
}
