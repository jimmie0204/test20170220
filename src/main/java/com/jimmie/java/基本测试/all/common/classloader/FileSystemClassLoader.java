package com.jimmie.java.基本测试.all.common.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Load Class from file system
 */
public class FileSystemClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = loadClassDataFromFile(name);
        if (classData == null) {
            return super.findClass(name);
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }
    
    @Override
    public Class<?> loadClass(String paramString) throws ClassNotFoundException {
    	System.out.println("用FileSystemClassLoader自己的loadClass=======================");
    	return super.loadClass(paramString);
    }

    private byte[] loadClassDataFromFile(String name) {
//        String localPath = "/Users/Jay" + File.separatorChar + "Desktop" + File.separatorChar + name.replace('.', File.separatorChar) + ".class";
      String localPath = "D:/WorkSpaces6/test20170220/target/classes" + File.separatorChar + name.replace('.', File.separatorChar) + ".class";

//    	String localPath = "D:/WorkSpaces6/test20170220/target/classes/com/jimmie/java/基本测试/all/common/java/lang/String.class";
		System.out.printf("localPath: %s\n", localPath);

        try {
            InputStream inputStream = new FileInputStream(localPath);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize]; // 4KB
            int bytesNumRead = 0;
            while ((bytesNumRead = inputStream.read(buffer)) != -1) {
                System.out.printf("bytesNumRead: %s bytes\n", bytesNumRead);
                byteArrayOutputStream.write(buffer, 0, bytesNumRead);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
