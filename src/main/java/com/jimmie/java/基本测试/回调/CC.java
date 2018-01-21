package com.jimmie.java.基本测试.回调;/**
 * Created by jimmie on 2018/1/17.
 */

/**
 * @author jimmie
 * @create 2018-01-17 下午2:43
 */

public class CC {
    public static void main(String[] args){
      BB b = new BB(){
          @Override
          public void eat(String name){

              say(name,11);
          }

          private void say(String name,int age) {
              System.out.println(name+"de age is "+age);
              super.eat(name);
          }
      };

      AA a = new AA() {
          @Override
          public void sing() {

          }
      };

      b.eat("jimmie");
    }
}
