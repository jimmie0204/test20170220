package com.jimmie.test.谷歌guava;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

public class StringTest {

	@Test
	public void test1(){
		final String joiner  = Joiner.on("-").skipNulls().join(Arrays.asList("1",null,"a", 5, 7));
		System.out.println(joiner);
	}
	
	@Test
	public void test1_1(){
//		List<String> mnemonicCodes = Lists.newArrayList("sdsgf",null,"","kkkk","sdfisngin||SDFSDF");
		List<String> mnemonicCodes = Lists.newArrayList("a","b","c");
		final String joiner  = Joiner.on("|").skipNulls().join(mnemonicCodes);
		System.out.println(joiner);
	}
	
	@Test
	public void test2(){
		String[] split = ",a,,b,".split(",");
		System.out.println(Joiner.on(":").join(split));
	}
	
	@Test
	public void test3(){
		 String string = "sds";
		string .getBytes(Charsets.UTF_8);

	}
	
	@Test
	public void test4(){
		List<Integer> asList = Ints.asList(1,2,4,6);
		System.out.println(Ints.join("-", 1,3,4,5));

	}
	
	@Test
	public void testHashMultiset(){
		HashMultiset<String> create = HashMultiset.create();
		
		create.add("a");
		create.add("b");
		create.add("a");
		
		System.out.println(create.count("a"));;

	}
}
