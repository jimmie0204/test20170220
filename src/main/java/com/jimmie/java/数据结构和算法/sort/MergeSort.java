package com.jimmie.java.数据结构和算法.sort;

/**
 * 归并排序 平均O(nlogn),最好O(nlogn),最坏O(nlogn);空间复杂度O(n);稳定;较复杂
 * 
 * @author zeng//浪费空间 不是最优
 *
 */
public class MergeSort {

	public static void merge(int[] a, int start, int mid, int end) {
		int[] tmp = new int[a.length];//浪费空间
		System.out.println("merge " + start + "~" + end);
		int i = start, j = mid + 1, k = start;
		while (i != mid + 1 && j != end + 1) {
			if (a[i] < a[j])
				tmp[k++] = a[i++];
			else
				tmp[k++] = a[j++];
		}
		while (i != mid + 1)
			tmp[k++] = a[i++];
		while (j != end + 1)
			tmp[k++] = a[j++];
		for (i = start; i <= end; i++)
			a[i] = tmp[i];
		for (int p : a)
			System.out.print(p + " ");
		System.out.println();
	}

	static void mergeSort(int[] a, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(a, start, mid);// 左边有序
			mergeSort(a, mid + 1, end);// 右边有序
			merge(a, start, mid, end);
		}
	}

	public static void main(String[] args) {
//		int[] b = { 49, 38, 65, 97, 76, 13, 27, 50 };
        int b[] = { 51, 46, 20, 18, 65, 97, 82, 30, 77, 50 };
		mergeSort(b, 0, b.length - 1);
	}
}