package com.jimmie.test.工作流;/**
 * Created by jimmie on 2018/11/27.
 */

/**
 * @author jimmie
 * @create 2018-11-27 下午12:04
 */

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

public class GetCustomerInfo implements Command {

    public boolean execute(Context ctx) throws Exception{
        System.out.println("Get customer info");
        ctx.put("customerName","George Burdell");
        return false;
    }

}
