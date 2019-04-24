package com.jimmie.test.mockito;/**
 * Created by jimmie on 2019/1/24.
 */

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

/**
 * @author jimmie
 * @create 2019-01-24 下午8:08
 */

public class MockTest2 {


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test(){
        Study schoool = mock(Study.class);
        when(schoool.learn()).thenReturn(2);
        System.out.println(schoool.learn());
    }

    @Test
    public void test1(){
        Study schoool = mock(Study.class);
        doReturn(12).when(schoool).learn();
        System.out.println(schoool.learn());
    }

    @Test
    public void test2(){
        Study schoool3 = spy(Study.class);
        when(schoool3.learn()).thenReturn(2);
        System.out.println(schoool3.learn());
    }

    @Test
    public void test3(){
        Study schoool3 = spy(Study.class);
        doReturn(12).when(schoool3).learn();
//        when(schoool3.learn()).thenReturn(2);
        System.out.println(schoool3.learn());
    }
}
