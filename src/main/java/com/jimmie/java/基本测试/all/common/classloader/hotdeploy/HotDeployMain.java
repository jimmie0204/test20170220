package com.jimmie.java.基本测试.all.common.classloader.hotdeploy;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

/**
 * @author jimmie
 * @create 2019-10-09 下午5:04
 */
public class HotDeployMain {

    public static void main(String[] args)
            throws ClassNotFoundException, InterruptedException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        while (true) {
            ClassLoader loader = new ClassLoader() {
                @Override
                public Class<?> loadClass(String name) throws ClassNotFoundException {
                    try {
                        String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";

                        InputStream is = getClass().getResourceAsStream(fileName);
                        if (is == null) {
                            return super.loadClass(name);
                        }

                        byte[] b = new byte[is.available()];

                        is.read(b);
                        return defineClass(name, b, 0, b.length);

                    } catch (IOException e) {
                        e.printStackTrace();
                        throw new ClassNotFoundException(name);
                    }
                }
            };

            Class clazz = loader.loadClass("com.jimmie.java.基本测试.all.common.classloader.hotdeploy.Account");
            Object account = clazz.newInstance();
            account.getClass().getMethod("operation", new Class[]{}).invoke(account);
            Thread.sleep(20000);
        }
    }
}
