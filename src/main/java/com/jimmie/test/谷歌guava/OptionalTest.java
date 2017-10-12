package com.jimmie.test.谷歌guava;

import org.junit.Test;

import com.google.common.base.Optional;
import com.jimmie.test.bean操作.Student;

public class OptionalTest {

	@Test
	public void test1(){
		Optional<Student> op = Optional.absent();
		System.out.println(op.isPresent());
		System.out.println(Optional.class.getCanonicalName());
	}
}
