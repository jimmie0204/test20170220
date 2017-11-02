package com.jimmie.java.基本测试.反射.test1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestC {

	public static void main(String[] args) {
		Class<?>[] clazzes = new Class<?>[2];
		clazzes[0] = E.class;
		clazzes[1] = F.class;
		
		Field[] feilds;//存放属性字段
		Constructor<?>[] constructors;//存放构造方法
		Method[] methods;//存放方法
		Class<?> superClass;//存放直接父类
		Class<?>[] superInterfaces;//存放所实现的借口
		
		for (Class<?> clazz : clazzes) {
			System.out.println("<" + clazz+ ">");
			
			/*查找属性字段*/
			feilds = clazz.getFields();
			System.out.println("\t<Fields>");
			for (Field field : feilds) {
				System.out.println("\t\t<Feild>" + field + "<Field/>");
			}
			System.out.println("\t<Fields>");
			
			/*查找构造方法*/
			constructors = clazz.getConstructors();
			System.out.println("\t<Construtors>");
			for (Constructor<?> constructor : constructors) {
				System.out.println("\t\t<Construtor>" + constructor + "</Construtor>");
			}
			System.out.println("\t</Construtors>");
			
			/*查找方法*/
			methods = clazz.getMethods();
			System.out.println("\t<Methods>");
			for (Method method : methods) {
				System.out.println("\t\t<Method>" + method + "</Method>");
			}
			System.out.println("\t</Methods>");
			
			/*查找父类*/
			superClass = clazz.getSuperclass();
			System.out.print("\t<SuperClass>");
			if(superClass != null)
				System.out.print(superClass);
			System.out.println("</SuperClass>");
			
			/*查找实现的借口*/
			superInterfaces = clazz.getInterfaces();
			System.out.println("\t<superInterfaces>");
			for (Class<?> superInterface : superInterfaces) {
				System.out.println("\t\t<superInterface>" + superInterface + "</superInterface>");
			}
			System.out.println("\t</superInterfaces>");
			
			System.out.println("</" + clazz.getName() + ">");
		}
	}

}
