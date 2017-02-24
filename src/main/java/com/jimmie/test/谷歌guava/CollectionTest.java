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
}
