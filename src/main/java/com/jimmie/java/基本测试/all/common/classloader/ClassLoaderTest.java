package com.jimmie.java.基本测试.all.common.classloader;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Jay on 5/4/17.
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, MalformedURLException {
//        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
//        for (int i = 0; i < urls.length; i++) {
//            System.out.println(urls[i].toExternalForm());
//        }

//        loadExtLibClass();
        loadClass();
        // mock String class
//        mockStringClass();

        // fileSystemClassLoader, load ~/Desktop/LocalClassCopy , print()
        loadFileSystemClass();
        // different classloader will load different class
        loadClassByDifferentLoader();

        // load Network class. load http://localhost/java/classloader/NetworkClass.class, it's under /Library/WebServer/Documents directory
//        loadNetworkClass();
    }

    private static void loadNetworkClass() throws ClassNotFoundException {
        String className = "classloader.NetworkClass";
        NetworkClassLoader networkClassLoader = new NetworkClassLoader();
        Class<?> clazz  = networkClassLoader.loadClass(className);

        Method printMethod = null;
        try {
            printMethod = clazz.getDeclaredMethod("print", null);
            printMethod.invoke(clazz.newInstance());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    private static void loadFileSystemClass() throws ClassNotFoundException {
        String className = "com.jimmie.java.基本测试.all.common.java.lang.String";
        FileSystemClassLoader fileSystemClassLoader = new FileSystemClassLoader();
        Class<?> clazz = fileSystemClassLoader.loadClass(className);
        System.out.println(clazz.getClassLoader());
        try {
            Method printMethod = clazz.getDeclaredMethod("printName", null);
            printMethod.invoke(clazz.newInstance(), null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void loadClassByDifferentLoader() throws ClassNotFoundException {
        FileSystemClassLoader classLoader1 = new FileSystemClassLoader();
        FileSystemClassLoader classLoader2 = new FileSystemClassLoader();

        Class clazz1 = classLoader1.loadClass("com.jimmie.java.基本测试.all.common.classloader.LocalClass");
        Class clazz2 = classLoader2.loadClass("com.jimmie.java.基本测试.all.common.classloader.LocalClass");

        System.out.println(ClassLoader.getSystemClassLoader()); // AppClassLoader
        System.out.println(clazz1.getClassLoader()); // FileSystemClassLoader
        System.out.println(clazz2.getClassLoader()); // FileSystemClassLoader

        try {
            Object object1 = clazz1.newInstance();
            Method printMethod = clazz1.getDeclaredMethod("print", null);
            printMethod.invoke(object1);

            Method setInstanceMethod = clazz1.getMethod("setInstance", Object.class);
            Object object2 = clazz2.newInstance();
            setInstanceMethod.invoke(object1, object2);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void mockStringClass() throws ClassNotFoundException {
        Class<?> stringClass = Class.forName("java.lang.String");
        try {
            Method printNameMethod = stringClass.getMethod("printName", null); // NoSuchMethodException
            System.out.printf("printNameMethod = %s", (printNameMethod == null));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private static void loadClass() throws ClassNotFoundException, MalformedURLException {
        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        Class<?> clazz1 = appClassLoader.loadClass("com.jimmie.java.基本测试.all.common.classloader.MusicPlayer");
        System.out.println(clazz1.getClassLoader());

        Class<?> clazz2 = Class.forName("com.jimmie.java.基本测试.all.common.classloader.MusicPlayer");
        ClassLoader classLoader = clazz2.getClassLoader();
        System.out.println(classLoader);

        Class<?> clazz3 = Class.forName("java.lang.String");
        System.out.println(clazz3.getClassLoader());
        
        Class<?> clazz5 = Class.forName("com.jimmie.java.基本测试.all.common.java.lang.String");
        System.out.println(clazz5.getClassLoader());

        Class<?> clazz4 = new NetworkClassLoader().loadClass("java.lang.String");
        System.out.println(clazz4.getClassLoader());
        
        URL[] baseUrls = {new URL("file:/D:/WorkSpaces6/test20170220/target/classes/com/jimmie/java/基本测试/all/common/java/lang/String.class")};
        URLClassLoader loader = new URLClassLoader(baseUrls, ClassLoader.getSystemClassLoader());
        Class clazz = loader.loadClass("com.jimmie.java.基本测试.all.common.java.lang.String");
        System.out.println(clazz.getClassLoader());
    }

    private static void loadExtLibClass() {
        // mv MusicPlayer.jar into jre/lib/ext/
        ClassLoader classLoader = new NetworkClassLoader();
        classLoader = classLoader.getParent().getParent(); // ExtClassLoader
        System.out.println(classLoader);
        try {
            classLoader.loadClass("classloader.MusicPlayer"); // this is in jre/lib/ext/
            classLoader.loadClass("classloader.MusicPlayer2");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
