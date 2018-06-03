package com.jimmie.test.谷歌guava;/**
 * Created by Jimmie on 2018/6/2.
 */

import com.google.common.base.Preconditions;
import com.google.common.collect.Table;

/**
 * @author jimmie
 * @create 2018-06-02 15:07
 */

public class Tables{

    public static <R,C> void putIncrOrDecr(Table<R,C,Integer> table,R rowKey,C columnKey,Integer changeValue){

        Preconditions.checkNotNull(table);
        Preconditions.checkNotNull(rowKey);
        Preconditions.checkNotNull(columnKey);

        Integer v = table.get(rowKey, columnKey);
        if(v==null){
            table.put(rowKey, columnKey,changeValue);
        }else{
            table.put(rowKey, columnKey,changeValue+v);
        }
    }
}
