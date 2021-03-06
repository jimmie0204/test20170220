package com.jimmie.test.typesafeConfig;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

//Whenever you write a library, allow people to supply a Config but
//also default to ConfigFactory.load if they don't supply one.
//Libraries generally have some kind of Context or other object
//where it's convenient to place the configuration.

public class SimpleLibContext {
 private Config config;

 // we have a constructor allowing the app to provide a custom Config
 public SimpleLibContext(Config config) {
     this.config = config;
//      This verifies that the Config is sane and has our
//      reference config. Importantly, we specify the "simple-lib"
//      path so we only validate settings that belong to this
//      library. Otherwise, we might throw mistaken errors about
//      settings we know nothing about.
     //默认的路径
     config.checkValid(ConfigFactory.defaultReference(), "simple-lib");
 /*    ClassLoader loader = Thread.currentThread().getContextClassLoader();
     Config computeCachedConfig = ConfigImpl.computeCachedConfig(loader, "defaultReference",  new Callable<Config>() {
            @Override
            public Config call() {
				Config unresolvedResources = Parseable
                        .newResources("typesafeConfig/reference",
                                ConfigParseOptions.defaults().setClassLoader(loader))
                        .parse().toConfig();
                return ConfigImpl.systemPropertiesAsConfig().withFallback(unresolvedResources).resolve();
            }
        });
     config.checkValid(computeCachedConfig, "simple-lib");*/
    
     
     
 }

 // This uses the standard default Config, if none is provided,
 // which simplifies apps willing to use the defaults
 public SimpleLibContext() {
     this(ConfigFactory.load());
 }

 // this is the amazing functionality provided by simple-lib
 public void printSetting(String path) {
     System.out.println("The setting '" + path + "' is: " + config.getString(path));
 }
}