package com.jimmie.java.基本测试.集合类;/**
 * Created by jimmie on 2018/3/16.
 */

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import org.junit.Test;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * @author jimmie
 * @create 2018-03-16 下午2:10
 */

public class MapTest {

    @Test
    public void test(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");

//        for (Map.Entry<Integer,String> entry:map.entrySet()){
//            if(entry.getValue()=="b")
//                map.remove(entry.getKey());
//        }

        Map<Integer, String> integerStringMap = Maps.filterValues(map, new com.google.common.base.Predicate<String>() {
            @Override
            public boolean apply(@Nullable String input) {
                return input != "b";
            }
        });

        map.put(4,"d");//map变，integerStringMap也变


        System.out.println(map.hashCode()+"====="+map.size());
        System.out.println(integerStringMap.hashCode()+"====="+integerStringMap.size()+"====="+integerStringMap.size());

    }
}
