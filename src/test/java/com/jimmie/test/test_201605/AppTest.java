package com.jimmie.test.test_201605;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.zip.CRC32;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{


    @Test
    public void test(){

        String ss = "  123.0987  ";

        Double aDouble = Double.valueOf(ss);
        assertEquals(123.0987,aDouble);

    }
}
