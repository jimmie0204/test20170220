package com.jimmie.test.序列化.fastSerialize;

import java.io.Serializable;
import java.util.Map;

public class MoreSimple  implements Serializable
{  
     private static final long serialVersionUID = -4914434736683567743L;  
     private String name;  
     private int age;  
     private int sex;
     public MoreSimple(){  
  
     }  
     public MoreSimple(String name,int age){  
         this.name = name;  
         this.age = age;  
     }  
  
     public String getName() {  
       return name;  
     }  
  
     public void setName(String name) {  
        this.name = name;  
     }  
  
     public int getAge() {  
        return age;  
     }  
  
     public void setAge(int age) {  
        this.age = age;  
     }  
  
}  