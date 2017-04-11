package com.jimmie.test.谷歌guava;

import java.util.ArrayList;

import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class ImmutableTest {

	@Test
	public void testList(){
		ArrayList<String> newArrayList = Lists.newArrayList();
		newArrayList.add("a");
		newArrayList.add("b");
		ImmutableList<String> copyOf = ImmutableList.copyOf(newArrayList);
		
		copyOf.add("c");
//		copyOf.clear();
	}
	
}
