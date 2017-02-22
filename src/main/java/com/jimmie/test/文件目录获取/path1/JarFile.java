package com.jimmie.test.文件目录获取.path1;

import java.io.InputStream;

//jar中读取资源文件
public class JarFile {

	/**
	 * ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream is = classloader.getResourceAsStream("com/xxx/xxxx/yourfile.xml");
	 */
	
	
	static {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream is = classloader.getResourceAsStream("com/xxx/xxxx/yourfile.xml");
	}
}
