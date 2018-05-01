package com.jimmie.java.designer.singleton;/**
 * Created by jimmie on 2018/4/28.
 */

import static com.google.common.base.Preconditions.checkState;

/**
 * @author jimmie
 * @create 2018-04-28 上午11:59
 */

public class BestSingletonFactory {

    /**
     * 使用单例工厂，减少ConfigClient对象的创建，提升效率
     */
    public static ConfigClient getClient() {
        checkState(ConfigClientHolder.isOk, "no client is available!");
        return ConfigClientHolder.configClient;
    }

    /**
     * 懒初始化，线程安全
     */
    private static class ConfigClientHolder {

        private static ConfigClient configClient;

        private static boolean isOk = false;

        private ConfigClientHolder() {
        }

        static {
            isOk = initConfigClient();
        }

        private static boolean initConfigClient() {
            return configClient.isOk();
        }
    }

    public static class ConfigClient {

        public Boolean isOk(){
            return true;

        }
    }
}
