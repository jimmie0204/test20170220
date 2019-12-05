package com.jimmie.java.designer.visitor;

import java.util.Random;

/**
 * @author jimmie
 * @create 2019-09-20 上午10:22
 */
// 员工基类
public abstract class Staff {

    public String name;
    public int kpi;// 员工KPI

    public Staff(String name) {
        this.name = name;
        kpi = new Random().nextInt(10);
    }
    // 核心方法，接受Visitor的访问
    public abstract void accept(Visitor visitor);
}