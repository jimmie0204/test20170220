package com.jimmie.java.基本测试.all.common.classloader;

/**
 * LocalClassCopy will be loaded by FileSystemClassLoader
 */
public class LocalClass {

    public void print() {
        System.out.println("Hi Here is LocalClass");
    }

    private LocalClass instance;
    
    public void setInstance(Object instance) {
        this.instance = (LocalClass) instance;
    }

}
