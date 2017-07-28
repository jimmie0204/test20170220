package com.jimmie.test.unsafe.test1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

import sun.misc.Unsafe;

public class NewClassTest {

	private static final Unsafe unsafe;
	
	static {
		try {
			unsafe = UnsafeUtil.getUnsafe();
		} catch (Exception ex) {
			throw new Error(ex);
		}
	}
	
	 public static void main(String[] args){  
//       testNewObject();  
//       testNewInstance();  
//       testConstructor();  
//       testConstructorWityParameterTypes();  
//       testUnsafeAllocateInstance();  
   }  
     
 
   public static void testUnsafeAllocateInstance(){  
         
       try {  
           DemoClass obj = (DemoClass)unsafe.allocateInstance(DemoClass.class);  
           System.out.println(obj.getValue1());  
           System.out.println(obj.getValue2());  
           obj.setValue1(1);  
           obj.setValue2(2);  
           System.out.println(obj.getValue1());  
           System.out.println(obj.getValue2());  
       } catch (InstantiationException e) {  
           e.printStackTrace();  
       }  
   }  
     
   public static void testNewObject(){  
       DemoClass obj = new DemoClass(1,2);  
       System.out.println(obj.getValue1());  
       System.out.println(obj.getValue2());  
   }  
     
   public static void testNewInstance(){  
       try {  
           DemoClass obj = DemoClass.class.newInstance();  
           System.out.println(obj.getValue1());  
           System.out.println(obj.getValue2());  
       } catch (InstantiationException e) {  
           e.printStackTrace();  
       } catch (IllegalAccessException e) {  
           e.printStackTrace();  
       }  
   }  
     
   public static void testConstructor(){  
       try {  
           Class[] cls = new Class[] { int.class, int.class };  
           Constructor c = DemoClass.class.getDeclaredConstructor(cls);  
           DemoClass obj = (DemoClass) c.newInstance(0, 0);  
           System.out.println(obj.getValue1());  
           System.out.println(obj.getValue2());  
       } catch (Exception e) {  
           e.printStackTrace();  
       }  
   }  
     
   public static void testConstructorWityParameterTypes(){  
       try {  
           Constructor[] c = DemoClass.class.getDeclaredConstructors();  
           Type[] parameterTypes = c[0].getGenericParameterTypes();  
           // 判断type类型，依次设置默认值  
           DemoClass obj = (DemoClass) c[0].newInstance(0, 0);  
           System.out.println(obj.getValue1());  
           System.out.println(obj.getValue2());  
       } catch (Exception e) {  
           e.printStackTrace();  
       }  
   } 
}
