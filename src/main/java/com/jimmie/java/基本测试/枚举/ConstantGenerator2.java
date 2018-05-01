package com.jimmie.java.基本测试.枚举;/**
 * Created by jimmie on 2018/4/17.
 */

import java.util.HashMap;

/**
 * @author jimmie
 * @create 2018-04-17 下午6:10
 */

public class ConstantGenerator2<T extends Enum & ConstantGenerator2.Constant> {
    private final Class<T> constant;
    private final HashMap<Integer, T> codeConstantMap = new HashMap<>();
    public static <T extends Enum & ConstantGenerator2.Constant> ConstantGenerator2 create(Class<T> constant) {
        return new ConstantGenerator2(constant);
    }

    private ConstantGenerator2(Class<T> constant) {
        this.constant = constant;
        for (T t : constant.getEnumConstants()) {
            codeConstantMap.put(t.getCode(), t);
        }
    }

    public T getByCode(int code) {
        return checkExist(codeConstantMap.get(checkNotNull(code)), "code", code);
    }


    private T checkExist(T t, String description, Object value) {
        if (t == null) {
            throw new IllegalArgumentException(constant.getSimpleName() + "没有" + description + "为" + value + "的枚举");
        }
        return t;
    }

    private <C> C checkNotNull(C reference) {
        if (reference == null) {
            throw new NullPointerException();
        }
        return reference;
    }

    public interface Constant {
        int getCode();

    }
}