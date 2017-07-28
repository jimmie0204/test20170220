package com.jimmie.java.数据结构和算法.区间;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RegionMerge {
	
	private List<Integer> regionNum = new ArrayList<>();
	
	public void putIn(Region ...regions){
		for(Region region:regions){
			regionNum.add(region.getLeftNum());
			regionNum.add(region.getRightNum());
		}
	}
	
	public List<Integer> getRegionNum(){
		return this.regionNum;
	}

		
	
	//获取左边第一个比给定数小的数
	public Item getLeftMore(Integer num){
		int size = regionNum.size();
		for(int i=0;i<size;i++){
			if(regionNum.get(i)>=num){
				if(i==0){
					return null;
				}else{
					return new Item(regionNum.get(i-1), i);
				}
			}
		}
		return null;
	}
	
	
	//获取右边第一个比给定数大的数
	public Item getRightMore(Integer num){
		int size = regionNum.size();
		for(int i=0;i<size;i++){
			if(regionNum.get(i)>=num){
				return new Item(regionNum.get(i), i+1);
			}else{
				
			}
		}
		return null;
	}
	
	public void printRegions(List<Integer> list){
		if(list.size()%2!=0){
			System.out.println("error===============");
			return ;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<list.size();i+=2){
			sb.append(new Region(list.get(i), list.get(i+1)).toString()).append(" ");
		}
		System.out.println(sb.toString());
	}
	
	class Item{
		private Integer value;
		private int i;
		public Item(Integer value, int i) {
			super();
			this.setValue(value);
			this.setI(i);
		}
		public Integer getValue() {
			return value;
		}
		public void setValue(Integer value) {
			this.value = value;
		}
		public int getI() {
			return i;
		}
		public void setI(int i) {
			this.i = i;
		}
		
	}

	static class Region{
		
		public Region(int leftNum, int rightNum) {
			super();
			this.leftNum = leftNum;
			this.rightNum = rightNum;
		}

		private int leftNum;
		
		private int rightNum;

		public int getLeftNum() {
			return leftNum;
		}

		public void setLeftNum(int leftNum) {
			this.leftNum = leftNum;
		}

		public int getRightNum() {
			return rightNum;
		}

		public void setRightNum(int rightNum) {
			this.rightNum = rightNum;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "("+leftNum+","+rightNum+")";
		}
	}
	
	public static void main(String[] args) {
		Region region = new Region(8,120);
		
		RegionMerge merge = new RegionMerge();
		List<Integer> regionNum = merge.getRegionNum();
		merge.putIn(new Region[]{new Region(7,11),new Region(14,20),new Region(21,25),new Region(1,5)});
		Collections.sort(regionNum);
		Item leftMore = merge.getLeftMore(region.getLeftNum());
		Item rightMore = merge.getRightMore(region.getRightNum());
		
		if(leftMore==null && rightMore==null){
			System.out.println("result:"+region.toString());
		}else if(leftMore==null){
			List<Integer> subList = new ArrayList<>();
			if(rightMore.getI()%2==0) {
				subList = regionNum.subList(rightMore.getI()-1, regionNum.size());
				subList.add(region.getLeftNum());
			}else{
				subList = regionNum.subList(rightMore.getI()-1, regionNum.size());
				subList.add(region.getLeftNum());
				subList.add(region.getRightNum());
			}
			Collections.sort(subList);
			merge.printRegions(subList);
		}else if(rightMore==null){
			List<Integer> subList = new ArrayList<>();
			if(leftMore.getI()%2==0) {
				subList = regionNum.subList(0, leftMore.getI());
				subList.add(region.getLeftNum());
				subList.add(region.getRightNum());
			}else{
				subList = regionNum.subList(0, leftMore.getI());
				subList.add(region.getRightNum());
			}
			Collections.sort(subList);
			merge.printRegions(subList);
		}else{
			List<Integer> subList1 = new ArrayList<>();
			List<Integer> subList2 = new ArrayList<>();
			if(leftMore.getI()%2==0){
				if(rightMore.getI()%2==0){
//					subList1 = regionNum.subList(0, leftMore.getI());
//					subList2 = regionNum.subList(rightMore.getI()-1, regionNum.size());
//					subList2.add(region.getLeftNum());
					regionNum.subList(leftMore.getI(), rightMore.getI()-1).clear();
					regionNum.add(region.getLeftNum());
				}else{
//					subList1 = regionNum.subList(0, leftMore.getI());
//					subList2 = regionNum.subList(rightMore.getI()-1, regionNum.size());
//					subList2.add(region.getLeftNum());
//					subList2.add(region.getRightNum());
					
					regionNum.subList(leftMore.getI(), rightMore.getI()-1).clear();
					regionNum.add(region.getLeftNum());
					regionNum.add(region.getRightNum());
				}
			}else{
				if(rightMore.getI()%2==0){
//					subList1 = regionNum.subList(0, leftMore.getI());
//					subList2 = regionNum.subList(rightMore.getI()-1, regionNum.size());
					regionNum.subList(leftMore.getI(), rightMore.getI()-1).clear();
				}else{
//					subList1 = regionNum.subList(0, leftMore.getI());
//					subList2 = regionNum.subList(rightMore.getI()-1, regionNum.size());
//					subList2.add(region.getRightNum());
					regionNum.subList(leftMore.getI(), rightMore.getI()-1).clear();
					regionNum.add(region.getRightNum());
				}
			}
//			merge.printRegions(subList1);
			Collections.sort(regionNum);
			merge.printRegions(regionNum);
		/*	List<Integer> subList = new ArrayList<>();
			subList.addAll(subList1);
			subList.addAll(subList2);
			Collections.sort(subList);
			merge.printRegions(subList);*/
		}
		
	}
}
