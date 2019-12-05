package com.jimmie.java.designer.visitor.my;

import com.jimmie.java.designer.visitor.Staff;
import com.jimmie.java.designer.visitor.Visitor;

import java.util.List;

/**
 * @author jimmie
 * @create 2019-09-20 上午10:23
 */
// 员工业务报表类
public class BusinessReport2 {

    private Visitor visitor;

    public BusinessReport2(Visitor visitor) {
        this.visitor = visitor;
    }

    /**
     * 为访问者展示报表
     * @param mStaffs
     */
    public void showReport(List<Staff> mStaffs) {
        for (Staff staff : mStaffs) {
//            visitor.visit(staff);
        }
    }
}
