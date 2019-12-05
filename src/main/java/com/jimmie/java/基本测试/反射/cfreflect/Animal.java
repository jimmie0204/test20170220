package com.jimmie.java.基本测试.反射.cfreflect;

import javax.annotation.CheckForNull;
import javax.annotation.Resource;

/**
 * @author jimmie
 * @create 2019-10-11 上午11:42
 */
public interface Animal {

    @Resource
    @CheckForNull
    @SuppressWarnings("dd")
    public void run();
}
