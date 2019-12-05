package com.jimmie.java.designer.visitor;

/**
 * @author jimmie
 * @create 2019-09-20 上午10:22
 */
public interface Visitor {

    // 访问工程师类型
    void visit(Engineer engineer);

    // 访问经理类型
    void visit(Manager manager);
}