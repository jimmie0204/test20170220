package com.jimmie.test.groovy.use

/**
 * Created by jimmie on 2018/11/30.
 */
class AppGroovy {

    static main(args) {
        def closure = { param -> println "hello ${param}" }
        closure("world")
    }
}
