package com.jimmie.test.mockito;
/**
 * Created by jimmie on 2018/1/15.
 */


import org.junit.Assert;
import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

/**
 * @author jimmie
 * @create 2018-01-15 下午6:59
 */

public class MockTest {

    @Test
    public void test(){

        Study schoool = mock(Study.class);
        Student st = mock(Student.class);
        st.setName("tiny");
        st.setAge(12);
        schoool.goToSchool();

        //调用验证，包括参数
        verify(st).setName("tiny");

        verify(st,times(2)).setAge(12);
        //调用顺序验证
        InOrder inorder = inOrder(schoool,st);
        inorder.verify(st).setName("tiny");
        inorder.verify(schoool).goToSchool();

        System.out.println(st.getName());
        Assert.assertEquals("tiny",st.getName());
    }


    @Test
    public void test2(){

        Student st = spy(Student.class);
        st.setName("tiny");
        st.setAge(12);

        System.out.println(st.getName());
        Assert.assertEquals("tiny",st.getName());
    }

}
