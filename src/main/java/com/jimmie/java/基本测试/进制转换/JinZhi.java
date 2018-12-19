package com.jimmie.java.基本测试.进制转换;/**
 * Created by jimmie on 2018/12/11.
 */

import org.junit.Test;

/**
 * @author jimmie
 * @create 2018-12-11 上午11:36
 *
 * JAVA 大神早就准备好了这个方法。
    Long.toString(N, 36)
    N是LONG型的十进制数
    其中36还可以是2-36进制的任何数
 */

public class JinZhi {

    @Test
    public void test(){
        Long num = 10l;
        String s = Long.toString(num, 36);
        String s1 = Long.toString(num, 2);
        System.out.println(s);
        System.out.println(s1);

    }

    @Test
    public void test2(){
        StringBuffer sb = new StringBuffer();
        String dealM = Long.toString(48179084, 36);
        String poiIdM = Long.toString(6463723, 36);
        int dealMLength = dealM.length();
        int poiIdMLength = poiIdM.length();

        while(dealMLength<6){
            sb.append("0").append(dealM);
            dealMLength++;
        }
        dealM = sb.toString();
        sb.setLength(0);
        while(poiIdMLength<6){
            sb.append("0").append(poiIdM);
            poiIdMLength++;
        }
        poiIdM = sb.toString();
        sb.setLength(0);
        System.out.println(sb.append(dealM).append(poiIdM).append("00000000000000000000").toString());;
    }

}
