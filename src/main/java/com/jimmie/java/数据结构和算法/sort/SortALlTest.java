package com.jimmie.java.数据结构和算法.sort;

import org.junit.Test;

public class SortALlTest {

	public final static int[] arr = {16,3,78,23,37,5,110,45,99,47,29,88};//12ge
	
	private static void print(int[] arrs){
		for(int t:arrs){
			System.out.print(t+" ");
		}
		System.out.println();
	}
	

	
	
	@Test
	public void xuanze(){
		System.out.println("排序前：");
		print(arr);
		int size = arr.length;
		long begin = System.currentTimeMillis();
		for(int i=0;i<size;i++){
			for(int j=i+1;j<size;j++){
				if(arr[i]>arr[j]){//
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
			print(arr);
		}
		long end = System.currentTimeMillis();
		System.out.println("排序后：");
		print(arr);
		System.out.println("排序时间:"+(end-begin));
	}
	
	
	//交换排序
	@Test
	public void MaoPao(){
		System.out.println("排序前：");
		print(arr);
		int size = arr.length;
		long begin = System.currentTimeMillis();
		for(int i=0;i<size;i++){
			for(int j=0;j<size-i-1;j++){
				if(arr[j]>arr[j+1]){//大数下沉,从小到大
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			print(arr);
		}
		long end = System.currentTimeMillis();
		System.out.println("排序后：");
		print(arr);
		System.out.println("排序时间:"+(end-begin));
		
	}
	
	@Test
	public void MaoPao2(){//3ms
		System.out.println("排序前：");
		print(arr);
		int size = arr.length;
		long begin = System.currentTimeMillis();
		for(int i=0;i<size;i++){
			for(int j=size-1;j>i;j--){
				if(arr[j]<arr[j-1]){//小数上浮,从小到大
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}
			print(arr);
		}
		long end = System.currentTimeMillis();
		System.out.println("排序后：");
		print(arr);
		System.out.println("排序时间:"+(end-begin));
		
	}
	
	@Test
	public void MaoPaoAdvanced(){
		System.out.println("排序前：");
		print(arr);
		int size = arr.length;
		long begin = System.currentTimeMillis();
		int flag= 1;
		for(int i=0;i<size&&flag==1;i++){
			flag=0;
			for(int j=0;j<size-i-1;j++){
				if(arr[j]>arr[j+1]){//大数下沉,从小到大
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					flag=1;
				}
			}
			print(arr);
		}
		long end = System.currentTimeMillis();
		System.out.println("排序后：");
		print(arr);
		System.out.println("排序时间:"+(end-begin));
		
	}
	
	@Test
	public void MaoPao2Advanced(){//3ms
		System.out.println("排序前：");
		print(arr);
		int size = arr.length;
		long begin = System.currentTimeMillis();
		int flag = 1;
		for(int i=0;i<size&&flag==1;i++){
			flag=0;
			for(int j=size-1;j>i;j--){
				if(arr[j]<arr[j-1]){//小数上浮,从小到大
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
					flag=1;
				}
			}
			print(arr);
		}
		long end = System.currentTimeMillis();
		System.out.println("排序后：");
		print(arr);
		System.out.println("排序时间:"+(end-begin));
		
	}
	
	//=====================快速排序=======================
	
	@Test
	public void kuaiPai(){
		System.out.println("排序前：");
		print(arr);
		long begin = System.currentTimeMillis();
		quick(arr);
		long end = System.currentTimeMillis();
		System.out.println("排序后：");
		print(arr);
		System.out.println("排序时间:"+(end-begin));
		
	}
	
    private static void quick(int[] a) {
        if(a.length>0){
            quickSort(a,0,a.length-1);
        }
    }

    private static void quickSort(int[] a, int low, int high) {
        if(low<high){ //如果不加这个判断递归会无法退出导致堆栈溢出异常
            int middle = getMiddle(a,low,high);
            quickSort(a, 0, middle-1);
            quickSort(a, middle+1, high);
        }
    }

    private static int getMiddle(int[] a, int low, int high) {
        int temp = arr[low];//基准元素
        while(low<high){
            //找到比基准元素小的元素位置
            while(low<high && arr[high]>=temp){
                high--;
            }
            arr[low] = arr[high]; 
            while(low<high && arr[low]<=temp){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;
    }
    
    //======================插入排序====================
    @Test
    public void charu(){
		System.out.println("排序前：");
		print(arr);
    	int size =arr.length;
		long begin = System.currentTimeMillis();
    	for(int i=1;i<size;i++){
    		int temp = arr[i];
    		int j;
    		for(j=i-1;j>=0;j--){
    			if(arr[j]>temp){
    				arr[j+1] = arr[j];
    			}else
    				break;
    		}
    		arr[j+1]=temp;
    		print(arr);
    	}
		long end = System.currentTimeMillis();
		System.out.println("排序后：");
		print(arr);
		System.out.println("排序时间:"+(end-begin));
    }

	
}
