package com.jimmie.test.谷歌guava;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class CollectionTest {

	@Test
	public void test1(){
//		List<String> list = null; //报空指针
		List<String> list = Lists.newArrayList();
		if(Iterables.isEmpty(list)){
			System.out.println("empty");
		}
	}

	@Test
	public void test2(){
		final List<Long> poiIds = Lists.asList(100101L,null);
		final List<Integer> attrIds = Lists.asList(111,222,null);

		System.out.println(poiIds);
		System.out.println(attrIds);
	}
}
