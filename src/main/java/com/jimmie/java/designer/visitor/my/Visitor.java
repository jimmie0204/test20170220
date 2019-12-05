package com.jimmie.java.designer.visitor.my;

import com.jimmie.java.designer.visitor.Engineer;
import com.jimmie.java.designer.visitor.Manager;

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