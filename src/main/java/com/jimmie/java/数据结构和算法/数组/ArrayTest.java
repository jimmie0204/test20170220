package com.jimmie.java.数据结构和算法.数组;

/**
 * O（n）复杂度打印二维数组
 * @author Administrator
 *
 */
public class ArrayTest {

	public static void printArray(int array[][] )
	{

	    for (int i = 0; i < 3*2; i++)
	    {
	        int x = i / 2;
	        int y = i%2;
	        System.out.format("行号为%d,列号为%d\n", x, y);
	        System.out.format("%d\n", array[x][y]);
	    }
	}
	
	public static void main(String[] args) {
	    int array[][] = { {1, 2}, {3, 4}, {5, 6} };
		printArray(array);
	}
}
