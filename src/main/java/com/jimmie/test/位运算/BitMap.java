package com.jimmie.test.位运算;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jimmie
 * @create 2019-09-11 下午4:23
 */
public class BitMap {
    private static final int N = 10000000;

    private int[] a = new int[N/32 + 1];

    /**
     * 设置所在的bit位为1
     * @param n
     */
    public void addValue(int n){
        //row = n / 32 求十进制数在数组a中的下标
        int row = n >> 5;
        //相当于 n % 32 求十进制数在数组a[i]中的下标
        a[row] |= 1 << (n & 0x1F);
    }

    // 判断所在的bit为是否为1
    public boolean exits(int n){
        int row = n >> 5;
        return (a[row] & ( 1 << (n & 0x1F))) != 0;
    }

    public void printArray(){
        System.out.println(Arrays.toString(a));
    }

    public void display(int row){
        System.out.println("BitMap位图展示");
        for(int i=0;i<row;i++){
            List<Integer> list = new ArrayList<Integer>();
            int temp = a[i];
            for(int j=0;j<32;j++){
                list.add(temp & 1);
                temp >>= 1;
            }
            System.out.println("a["+i+"]" + list);
        }
    }

    public static void main(String[] args){
//        int num[] = {1,5,30,32,64,56,159,120,21,17,35,45};
        int num[] = {2,3};
        BitMap map = new BitMap();
        for(int i=0;i<num.length;i++){
            map.addValue(num[i]);
        }

        int temp = 120;
        if(map.exits(temp)){
            System.out.println("temp:" + temp + "has already exists");
        }
        System.out.println(map.exits(3));
        map.display(5);
//        map.printArray();
    }
}
