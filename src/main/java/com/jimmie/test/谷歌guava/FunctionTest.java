package com.jimmie.test.谷歌guava;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import javax.annotation.Nullable;

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

	@Test
	public void test2(){
		List<Integer> list = Lists.newArrayList(1,2,3,4,5,6);

		List<Integer> transform = Lists.transform(list, new Function<Integer, Integer>() {
			@Nullable
			@Override
			public Integer apply(@Nullable Integer input) {
				System.out.println("转换数据===" + input);
				return input * 2;
			}
		});

		System.out.println(transform.get(0));//懒转换
		System.out.println(transform);//每次都转换


	}
	
}
