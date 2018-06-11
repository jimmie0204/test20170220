package com.jimmie.test.谷歌guava;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
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

	@Test
	public void test3(){
		Table<String,Integer,Integer> tables1= HashBasedTable.create();


//		tables1.put("10001",1,10);
//
//		tables1.put("10002",1,2);

		Tables.putIncrOrDecr(tables1,"10001",1,10);
		Tables.putIncrOrDecr(tables1,"10002",1,2);
		Tables.putIncrOrDecr(tables1,"10001",1,5);

		Table<String,Integer,Integer> tables2= HashBasedTable.create();
		Tables.putIncrOrDecr(tables2,"10001",1,15);
		Tables.putIncrOrDecr(tables2,"10001",2,5);
		Tables.putIncrOrDecr(tables2,"10003",1,2);

        Iterator<Table.Cell<String, Integer, Integer>> iterator = tables2.cellSet().iterator();
        while(iterator.hasNext()){
            Table.Cell<String, Integer, Integer> temp = iterator.next();
            String rowKey = temp.getRowKey();
            Integer columnKey = temp.getColumnKey();

            if(tables1.contains(rowKey,columnKey)){
                iterator.remove();
            }

        }

/*        for(Table.Cell<String,Integer,Integer> temp:){
			String rowKey = temp.getRowKey();
			Integer columnKey = temp.getColumnKey();

			if(tables1.contains(rowKey,columnKey)){
				Integer integer = tables1.get(rowKey, columnKey);
				Tables.putIncrOrDecr(tables2,rowKey,columnKey,-integer);
			}
		}*/

		Integer integer = tables1.get("10001", 1);
		Integer integer1 = tables1.get("10005", 1);
		System.out.println(integer);
		System.out.println(integer1);
        System.out.println(tables1);
        System.out.println(tables2);


	}
}
