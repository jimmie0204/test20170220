package com.jimmie.java.designer.visitor;

import java.util.Random;

/**
 * @author jimmie
 * @create 2019-09-20 上午10:23
 */
// 工程师
public class Engineer extends Staff {

    public Engineer(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    // 工程师一年的代码数量
    public int getCodeLines() {
        return new Random().nextInt(10 * 10000);
    }
}