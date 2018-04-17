package com.jimmie.java.基本测试.枚举;/**
 * Created by jimmie on 2018/4/17.
 */

import java.util.HashMap;

/**
 * @author jimmie
 * @create 2018-04-17 下午6:10
 */

public class ConstantGenerator<T extends Enum & ConstantGenerator.Constant> {
    private final Class<T> constant;
    private final HashMap<Integer, T> codeConstantMap = new HashMap<>();
    private final HashMap<String, T> fieldConstantMap = new HashMap<>();

    public static <E extends Enum & ConstantGenerator.Constant> ConstantGenerator<E> create(Class<E> constant) {
        return new ConstantGenerator<>(constant);
    }

    private ConstantGenerator(Class<T> constant) {
        this.constant = constant;
        for (T t : constant.getEnumConstants()) {
            codeConstantMap.put(t.getCode(), t);
            fieldConstantMap.put(t.getField(), t);
        }
    }

    public T getByCode(int code) {
        return checkExist(codeConstantMap.get(checkNotNull(code)), "code", code);
    }

    public T getByField(String field) {
        return checkExist(fieldConstantMap.get(checkNotNull(field)), "field", field);
    }

    public int getCode(String field) {
        return getByField(field).getCode();
    }

    public String getField(Integer code) {
        return getByCode(code).getField();
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

        String getField();
    }
}