package com.jimmie.java.基本测试;

public class ThisTest {

	public void method() {
		System.out.println("TestThis.method()");
	}

	public class Inner {
		public ThisTest getThisTest() {
			return ThisTest.this;
		}
		public Inner getThisTest2() {
			return this;
		}
	}

	public Inner getInner() {
		return new Inner();
	}

	public static void main(String[] args) {
		ThisTest tt = new ThisTest();
		Inner in = tt.getInner();
		ThisTest t = in.getThisTest();
		System.out.println(tt == t);
		System.out.println(in.getThisTest().getClass());
		System.out.println(in.getThisTest2().getClass());
	}

}