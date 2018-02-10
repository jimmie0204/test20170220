package com.jimmie.test.fastjson.test1;/**
 * Created by Jimmie on 2018/2/4.
 */

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author jimmie
 * @create 2018-02-04 17:54
 */
public class TypeReference<T> {

    private final Type type;

    public TypeReference() {
        Type superClass = getClass().getGenericSuperclass();

        type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
    }

    public Type getType() {
        return type;
    }

    public static final Type LIST_STRING = new TypeReference<List<String>>() {
    }.getType();
}