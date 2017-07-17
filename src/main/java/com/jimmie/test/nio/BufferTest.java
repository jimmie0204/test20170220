package com.jimmie.test.nio;

import java.nio.CharBuffer;

public class BufferTest {

    public static void main(String[] args){

        //通过静态方法创建一个CharBuffer
        System.out.println("创建buffer之后: ");
        CharBuffer buffer = CharBuffer.allocate(10);
        System.out.println("position: "+buffer.position());
        System.out.println("limit: "+buffer.limit());
        System.out.println("capacity: "+buffer.capacity());

        ///向buffer里放三个字符
        buffer.put("a");
        buffer.put("b");
        buffer.put("c");

        ///为使用buffer做准备
        System.out.println("在向buffer中装入数据之后：");
        System.out.println("position: "+buffer.position());
        System.out.println("limit: "+buffer.limit());
        System.out.println("capacity: "+buffer.capacity());
        System.out.println("调用flip()方法后: ");
        buffer.flip();
        System.out.println("position: "+buffer.position());
        System.out.println("limit: "+buffer.limit());
        System.out.println("capacity: "+buffer.capacity());

        ///读取buffer中的元素,以绝对方式和相对方式两种
        //绝对方式不会改变position指针的
        //而相对方式每次都会让position指针后移一位
        System.out.println(buffer.get());
        System.out.println(buffer.get(2));

        System.out.println();
        System.out.println("调用clear()后: ");
        //调用clear()方法,为再次向buffer中输入数据做准备
        //但是这个方法只是移动各个指针的位置,而不会清空缓冲区中的数据
        buffer.clear();
        System.out.println("position: "+buffer.position());
        System.out.println("limit: "+buffer.limit());
        System.out.println("capacity: "+buffer.capacity());

        ///clear()方法没有清空缓冲区
        //所以还可以通过绝对方式来访问缓冲区里面的内容
        System.out.println(buffer.get(2));
    }
}