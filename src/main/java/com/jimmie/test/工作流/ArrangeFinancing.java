package com.jimmie.test.工作流;/**
 * Created by jimmie on 2018/11/27.
 */

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

/**
 * @author jimmie
 * @create 2018-11-27 下午12:06
 */

public class ArrangeFinancing implements Command {

    public boolean execute(Context ctx) throws Exception {
        System.out.println("Arrange financing");
//        int i = 1/0;//异常拦截测试
        return false;
    }

}
