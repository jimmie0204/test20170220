package com.jimmie.test.工作流;/**
 * Created by jimmie on 2018/11/27.
 */

/**
 * @author jimmie
 * @create 2018-11-27 下午12:08
 */
import org.apache.commons.chain.impl.ChainBase;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.junit.Test;

public class SellVehicleChain extends ChainBase {

    public SellVehicleChain() {
        super();
        addCommand(new GetCustomerInfo());
        addCommand(new TestDriveVehicle());
        addCommand(new NegotiateSale());
        addCommand(new ArrangeFinancing());
        addCommand(new CloseSale());
    }


}