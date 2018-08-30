package com.jimmie.test.aviator;/**
 * Created by jimmie on 2018/8/29.
 */

import com.googlecode.aviator.AviatorEvaluator;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jimmie
 * @create 2018-08-29 下午6:48
 */

public class AviatorTest {

    @Test
    public void test() {
        Object execute = AviatorEvaluator.execute("string.length('hello')");//求字符串长度
        System.out.println(execute);
        Object execute2 = AviatorEvaluator.execute("string.contains('你这里无wifi','有wifi')? 1:string.contains('你这里无wifi','无sswifi')? 0:''");  //判断字符串是否包含字符串AviatorEvaluator.execute("string.startsWith('hello','h')");  //是否以子串开头AviatorEvaluator.execute("string.endsWith('hello','llo')");是否以子串结尾
        System.out.println(execute2);
        Object execute3 = AviatorEvaluator.execute("math.pow(-3,2)");   //求n次方
        System.out.println(execute3);
        Object execute4 = AviatorEvaluator.execute("math.sqrt(14.0)");   //开 平方根
        System.out.println(execute4);
        Object execute5 = AviatorEvaluator.execute("math.sin(20)");    //正弦函数
        System.out.println(execute5);

        Object execute6 = AviatorEvaluator.execute(" 'a\"b' ");//字符串 a'b
        System.out.println(execute6);
        Object execute7 = AviatorEvaluator.execute(" \"a\'b\" ");  //字符串 a"b
        System.out.println(execute7);
        Object execute8 = AviatorEvaluator.execute(" 'hello'+3 ");  //字符串 hello 3
        System.out.println(execute8);
        Object execute9 = AviatorEvaluator.execute(" 'hello '+ unknow ");  //字符串 hello null
        System.out.println(execute9);
        Object execute9_1 = AviatorEvaluator.exec(" 'hello '+ ppp ",123);  //变量
        System.out.println(execute9_1);
        Object execute9_2 = AviatorEvaluator.exec(" 'hello '+ 'ppp' ",123);  //字符串
        System.out.println(execute9_2);

        Map<String, Object> env = new HashMap<String, Object>();
        env.put("yourname", "dddd");
        env.put("p100001", "你这里无wifi");
        Object result = AviatorEvaluator.execute("string.length(yourname)", env);
        System.out.println(result);

        Object execute10 = AviatorEvaluator.execute("string.contains(p100001,'有wifi')? 1:string.contains(p100001,'无wifi')? 0:''",env);  //判断字符串是否包含字符串AviatorEvaluator.execute("string.startsWith('hello','h')");  //是否以子串开头AviatorEvaluator.execute("string.endsWith('hello','llo')");是否以子串结尾
        System.out.println(execute10);

        Object execute11 = AviatorEvaluator.exec("string.contains(p100001,'有wifi')? 1:string.contains(p100001,'无wifi')? 0:''","你这里有wifi");  //判断字符串是否包含字符串AviatorEvaluator.execute("string.startsWith('hello','h')");  //是否以子串开头AviatorEvaluator.execute("string.endsWith('hello','llo')");是否以子串结尾
        System.out.println(execute11);
    }
}
