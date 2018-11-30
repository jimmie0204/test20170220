package com.jimmie.test.工作流;/**
 * Created by jimmie on 2018/11/27.
 */

import org.apache.commons.chain.Catalog;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.junit.Test;

/**
 * @author jimmie
 * @create 2018-11-27 下午12:10
 *  blog:https://www.cnblogs.com/xiaoerlang/p/3345236.html
 */

public class WorkFlowTest {


    @Test
    public void test() throws Exception {
        Command process = new SellVehicleChain();
        Context ctx = new ContextBase();
        process.execute(ctx);
    }

    @Test
    public void test2() throws Exception {
        Command process = new SellVehicleChain();
        Context ctx = new SellVehicleContext();
        process.execute(ctx);
    }

    @Test
    public void test3() throws Exception {
        CatalogLoader loader = new CatalogLoader();
        Catalog sampleCatalog = loader.getCatalog("chain-config.xml","");
        Command command = sampleCatalog.getCommand("sell-vehicle");
        Context ctx = new SellVehicleContext();
        command.execute(ctx);
    }

    @Test
    public void test4() throws Exception {
        CatalogLoader loader = new CatalogLoader();
        Catalog sampleCatalog = loader.getCatalog("chain-config2.xml","auto-sales");
        Command command = sampleCatalog.getCommand("sell-vehicle");
        Context ctx = new SellVehicleContext();
        command.execute(ctx);
    }
}
