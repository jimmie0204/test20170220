package com.jimmie.java.基本测试.引用;/**
 * Created by jimmie on 2018/10/12.
 */


import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * @author jimmie
 * @create 2018-10-12 下午5:03
 */

public class SoftReferenceDemo {

    private static ReferenceQueue<MyObject> queue = new ReferenceQueue<>();

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(3000);
        MyObject object = new MyObject();
        SoftReference<MyObject> softRef = new SoftReference(object, queue);
        new Thread(new CheckRefQueue()).start();

        object = null;
        System.gc();
        System.out.println("After GC : Soft Get = " + softRef.get());
        System.out.println("分配大块内存");

        /**
         * ====================== 控制台打印 ======================
         * After GC : Soft Get = I am MyObject.
         * 分配大块内存
         * MyObject's finalize called
         * Object for softReference is null
         * After new byte[] : Soft Get = null
         * ====================== 控制台打印 ======================
         *
         * 总共触发了 3 次 full gc。第一次有System.gc();触发；第二次在在分配new byte[5*1024*740]时触发，
         * 然后发现内存不够，于是将softRef列入回收返回，接着进行了第三次full gc。
         */
//        byte[] b = new byte[5*1024*740];

        /**
         * ====================== 控制台打印 ======================
         * After GC : Soft Get = I am MyObject.
         * 分配大块内存
         * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
         *      at com.bayern.multi_thread.part5.SoftReferenceDemo.main(SoftReferenceDemo.java:21)
         * MyObject's finalize called
         * Object for softReference is null
         * ====================== 控制台打印 ======================
         *
         * 也是触发了 3 次 full gc。第一次有System.gc();触发；第二次在在分配new byte[5*1024*740]时触发，然后发现内存不够，于是将softRef列入回收返回，接着进行了第三次full gc。当第三次 full gc 后发现内存依旧不够用于分配new byte[5*1024*740]，则就抛出了OutOfMemoryError异常。
         */
        byte[] b = new byte[1*1024*790];

        System.out.println("After new byte[] : Soft Get = " + softRef.get());
    }

    public static class CheckRefQueue implements Runnable {

        Reference<MyObject> obj = null;

        @Override
        public void run() {
            try {
                obj = (Reference<MyObject>) queue.remove();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (obj != null) {
                System.out.println("Object for softReference is " + obj.get());
            }

        }
    }

    public static class MyObject {

        @Override
        protected void finalize() throws Throwable {
            System.out.println("MyObject's finalize called");
            super.finalize();
        }

        @Override
        public String toString() {
            return "I am MyObject.";
        }
    }

}
