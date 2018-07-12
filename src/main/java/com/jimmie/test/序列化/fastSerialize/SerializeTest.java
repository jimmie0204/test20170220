package com.jimmie.test.序列化.fastSerialize;/**
 * Created by Jimmie on 2018/6/27.
 */

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author jimmie
 * @create 2018-06-27 22:47
 */

public class SerializeTest {

    private Simple simple;
    @Before
    public void make(){
        simple = new Simple();
        simple.setAge(12);
        simple.setName("sd");
    }
    @Test
    public void test(){

        byte[] serialize = HessianSerializer.serialize(simple);
        System.out.println(Arrays.toString(serialize));
        Simple deserialize = HessianSerializer.deserialize(serialize, Simple.class);
        System.out.println(deserialize);

    }


    @Test
    public void test2(){
        byte[] serialize = ProtostuffSerializer.serialize(simple);
        System.out.println(Arrays.toString(serialize));
        Simple deserialize = ProtostuffSerializer.deserialize(serialize, Simple.class);
        System.out.println(deserialize);
    }

}
