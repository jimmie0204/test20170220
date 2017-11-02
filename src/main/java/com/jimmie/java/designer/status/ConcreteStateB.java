package com.jimmie.java.designer.status;

public class ConcreteStateB implements State {

    @Override
    public void handle(String sampleParameter) {
        
        System.out.println("ConcreteStateB handle ：" + sampleParameter);
    }

}