package com.jimmie.java.基本测试.all.dataStructure.annotation.compile;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Jay on 5/3/17.
 */
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.TYPE, ElementType.METHOD})
public @interface Generator {
}
