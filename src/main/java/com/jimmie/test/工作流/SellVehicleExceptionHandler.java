package com.jimmie.test.工作流;/**
 * Created by jimmie on 2018/11/27.
 */

/**
 * @author jimmie
 * @create 2018-11-27 下午2:34
 * 把异常处理命令放在链的第一个位置
 */

import org.apache.commons.chain.Context;
import org.apache.commons.chain.Filter;

public class SellVehicleExceptionHandler implements Filter {

    public boolean execute(Context context) throws Exception {
        System.out.println("Filter.execute() called.");
        return false;
    }

    public boolean postprocess(Context context, Exception exception) {
        if (exception == null)
            return false;
        System.out.println("Exception " + exception.getMessage() + " occurred.");
        return true;
    }

}
