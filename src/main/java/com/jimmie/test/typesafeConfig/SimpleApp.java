package com.jimmie.test.typesafeConfig;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class SimpleApp {
    public static void main(String[] args) {
        // example of how system properties override; note this
        // must be set before the config lib is used
        System.setProperty("simple-lib.whatever", "This value comes from a system property");

        // Load our own config values from the default location,
        // application.conf
        Config conf = ConfigFactory.load("typesafeConfig/application.conf");
        System.out.println("The answer is: " + conf.getString("simple-app.answer"));
//        System.out.println(conf.getString("simple-lib.foo"));
//        System.out.println(conf.getString("simple-lib.hello"));
//        System.out.println(conf.getString("simple-lib.whatever"));
        

//         In this simple app, we're allowing SimpleLibContext() to
//         use the default config in application.conf ; this is exactly
//         the same as passing in ConfigFactory.load() here, so we could
//         also write "new SimpleLibContext(conf)" and it would be the same.
//         (simple-lib is a library in this same examples/ directory).
//         The point is that SimpleLibContext defaults to ConfigFactory.load()
//         but also allows us to pass in our own Config.
        SimpleLibContext context = new SimpleLibContext(conf);
        context.printSetting("simple-lib.foo");
        context.printSetting("simple-lib.hello");
        context.printSetting("simple-lib.whatever");
    }
}