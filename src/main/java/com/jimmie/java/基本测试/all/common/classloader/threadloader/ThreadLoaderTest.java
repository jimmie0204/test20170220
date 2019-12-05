package com.jimmie.java.基本测试.all.common.classloader.threadloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author jimmie
 * @create 2019-10-09 下午3:24
 */
public class ThreadLoaderTest {

    public static void main(String[] args) {
        DiskClassLoader1 diskLoader1 = new DiskClassLoader1("/Users/jimmie/");
        Class cls1 = null;
        try {
            //加载class文件
            cls1 = diskLoader1.loadClass("com.frank.test.SpeakTest");
            System.out.println(cls1.getClassLoader().toString());
            if (cls1 != null) {
                try {
                    Object obj = cls1.newInstance();
                    Method method = cls1.getDeclaredMethod("speak", null);
                    //通过反射调用Test类的speak方法
                    method.invoke(obj, null);
                } catch (InstantiationException | IllegalAccessException
                        | NoSuchMethodException
                        | SecurityException |
                        IllegalArgumentException |
                        InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }

        DiskClassLoader diskLoader = new DiskClassLoader("/Users/jimmie/aa");
        System.out.println("Thread " + Thread.currentThread().getName() + " classloader: " + Thread.currentThread().getContextClassLoader().toString());
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("Thread " + Thread.currentThread().getName() + " classloader: " + Thread.currentThread().getContextClassLoader().toString());

                // TODO Auto-generated method stub
                try {
                    //加载class文件
                    //  Thread.currentThread().setContextClassLoader(diskLoader);
                    //Class c = diskLoader.loadClass("com.frank.test.SpeakTest");
                    ClassLoader cl = Thread.currentThread().getContextClassLoader();
                    Class c = cl.loadClass("com.frank.test.SpeakTest");
                    // Class c = Class.forName("com.frank.test.SpeakTest");
                    System.out.println(c.getClassLoader().toString());
                    if (c != null) {
                        try {
                            Object obj = c.newInstance();
                            Method method = c.getDeclaredMethod("speak", null);
                            //通过反射调用Test类的say方法
                            method.invoke(obj, null);
                        } catch (InstantiationException | IllegalAccessException
                                | NoSuchMethodException
                                | SecurityException |
                                IllegalArgumentException |
                                InvocationTargetException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
