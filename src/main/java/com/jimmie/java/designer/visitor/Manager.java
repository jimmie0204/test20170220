package com.jimmie.java.designer.visitor;

import java.util.Random;

/**
 * @author jimmie
 * @create 2019-09-20 上午10:23
 */
// 经理
public class Manager extends Staff {

    public Manager(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    // 一年做的产品数量
    public int getProducts() {
        return new Random().nextInt(10);
    }
}