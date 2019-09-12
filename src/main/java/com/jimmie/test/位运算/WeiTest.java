package com.jimmie.test.位运算;

import org.junit.Test;

/**
 * 计算机存储的是补码
 */
public class WeiTest {

    @Test
    public void test1() {
        int i = 3;
        System.out.println(3 >> 1);
    }

    @Test
    public void test2() {
        int base = 3;

        for (int i = 0; i < 10; i++) {
            System.out.println(i & base);
        }
    }

    @Test
    public void test3() {
        System.out.println(1 << 29);
    }

    @Test
    public void test4() {
        Integer i = 10;
        System.out.println(i.byteValue());
    }

    @Test
    public void test5() {
        System.out.println(-1L ^ (-1L << 5));
    }

    @Test
    public void test5_1() {
        System.out.println(Long.toBinaryString(-1L));//-1L
        System.out.println(Long.toBinaryString(1L));//1L
        System.out.println(Long.toBinaryString(-1L << 5));//-32L
        System.out.println(Long.toBinaryString(1L << 5));//32L
        System.out.println(Long.toBinaryString(-1L ^ (-1L << 5)));//32L
        System.out.println("==============================");
        System.out.println(Integer.toBinaryString(-1));//-1//11111111111111111111111111111111
        System.out.println(Integer.toBinaryString(1));//1
        System.out.println(Integer.toBinaryString(-1 << 5));//-32//11111111111111111111111111100000
        System.out.println(Integer.toBinaryString(1 << 5));//32

    }

    @Test
    public void test5_2() {
        System.out.println(Integer.toBinaryString(63));//1
        System.out.println(Integer.toBinaryString(32));//1
        System.out.println(Integer.toBinaryString(63 ^ 32));//1
    }

    @Test
    public void test6() {
        Long i = -1L;
        System.out.println(Long.toBinaryString(-1L));
        System.out.println(Long.toBinaryString(-1L << 5));
        System.out.println(Long.toBinaryString(-1L ^ (-1L << 5)));
        System.out.println(Long.toBinaryString(i).length());
    }

    @Test
    public void test6_2() {
        int a = -5;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(a >> 1));
        System.out.println(a >> 1);
        System.out.println(Integer.toBinaryString(a >>> 1));
        System.out.println(a >>> 1);
    }

    @Test
    public void test7_1() {
        int a = 3, b = 4;
        int c = a ^ a;
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
        System.out.println("a=" + a + ",b=" + b);
    }

    @Test
    public void test7() {
        int n = 1;
        System.out.println(Integer.toBinaryString(n));//原码
        System.out.println(Integer.toBinaryString(~n));//反码
        System.out.println(Integer.toBinaryString(-n));//补码

        System.out.println(-n & n);
        System.out.println("=============");

        int m = -1;
        System.out.println(Integer.toBinaryString(m));//原码
        System.out.println(Integer.toBinaryString(~m));//反码
        System.out.println(Integer.toBinaryString(-m));//补码

        System.out.println(-m & m);

    }

    @Test
    public void test8() {
        int n = 13;
        System.out.println(Integer.toBinaryString(n));//原码
        System.out.println(Integer.toBinaryString(~n));//反码
        System.out.println(Integer.toBinaryString(-n));//补码
        System.out.println(Integer.toBinaryString(~n + 1));//补码

        System.out.println(~(~n + 1) + 1);
    }

    /**
     * 输出一个int的二进制数
     *
     * @param num
     */
    private static void printInfo(int num) {
        System.out.println(Integer.toBinaryString(num));
    }

    @Test
    public void test9() {
        int number = 2 << 32 - 1;
        //原始数二进制
        printInfo(number);
        number = number << 1;
        //左移一位
        printInfo(number);
        number = 2 << 32 - 1;
        number = number >> 1;
        //右移一位
        printInfo(number);
        byte a = 'A';
        System.out.println(a - 1);
    }

    @Test
    public void test10() {
        int h;
        int i = (h = "sdfsd".hashCode()) ^ (h >>> 16);
        System.out.println(Integer.toBinaryString(i));
        System.out.println(1 << 31);
        System.out.println(Integer.toBinaryString(1 << 31));

    }

    @Test
    public void test11() {
        int n = -1;
        System.out.println(Integer.toBinaryString(n));//补码
        System.out.println(Integer.toBinaryString(n - 1));//反码
        System.out.println(Integer.toBinaryString(-n));//补码
        System.out.println(Integer.toBinaryString(~n + 1));//补码

        System.out.println(~(~n + 1) + 1);
        System.out.println(Math.floorMod(1,128));
    }

    @Test
    public void test12() {
        int n = 1<<31;
        System.out.println(Integer.toBinaryString(n));//补码
        System.out.println(Integer.toBinaryString(n - 1));//反码
        System.out.println(Integer.toBinaryString(-n));//补码
        System.out.println(Integer.toBinaryString(~n + 1));//补码

        System.out.println(~(~n + 1) + 1);
    }

    public void addValue(int n, int[] a){
        //row = n / 32 求十进制数在数组a中的下标
        int row = n >> 5;
        //相当于 n % 32 求十进制数在数组a[i]中的下标
        System.out.println("插入前a["+row+"]="+a[row]);
        System.out.println(Integer.toBinaryString(a[row]));//补码
        a[row] |= 1 << (n & 0x1F);
        System.out.println("插入后a["+row+"]="+a[row]);
        System.out.println(Integer.toBinaryString(a[row]));//补码
    }
    @Test
    public void test13() {
        int[] a = new int[]{0, 0};
        int n = 33;
//        a[row] |= 1 << (n & 0x1F);
        System.out.println(n % 32);
        System.out.println(n & 0x1F);
        System.out.println(1 << (n & 0x1F));
//        a[0] |= 1 << (n & 0x1F);
        System.out.println(a[0]);
        System.out.println(a[0] |= 1 << (n & 0x1F));
        System.out.println(a[0]);
        System.out.println(1>>31);
        System.out.println(1<<31);//-2 147 483 648
        System.out.println(Integer.toBinaryString(1<<31));//补码
    }

    @Test
    public void test13_2(){
        int[] a = new int[]{0, 0};
        int n = 2;
        addValue(n,a);
        n=3;
        addValue(n,a);
    }


}


