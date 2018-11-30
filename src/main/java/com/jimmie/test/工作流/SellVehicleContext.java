package com.jimmie.test.工作流;/**
 * Created by jimmie on 2018/11/27.
 */

/**
 * @author jimmie
 * @create 2018-11-27 下午12:08
 */

import org.apache.commons.chain.impl.ContextBase;

public class SellVehicleContext extends ContextBase {

    private String customerName;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String name) {
        this.customerName = name;
    }

}
