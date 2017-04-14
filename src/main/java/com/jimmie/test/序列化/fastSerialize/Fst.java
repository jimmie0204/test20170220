package com.jimmie.test.序列化.fastSerialize;

import java.io.IOException;

import org.nustaq.serialization.FSTConfiguration;

public class Fst {  
    public static void main(String[] args) throws IOException, ClassNotFoundException {  
        // 对字符串Hello World进行反序列化  
        String str = "Hello World !";  
        // TemplateItem item = new TemplateItem();  
        FSTConfiguration conf = FSTConfiguration.createDefaultConfiguration();  
  
        byte[] bytes = conf.asByteArray(str);  
        System.out.println(bytes.length);  
  
        //  
        //   
        str = (String) conf.asObject(bytes);  
  
        System.out.println(str);  
    }  
  
}  