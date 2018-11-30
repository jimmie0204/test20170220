package com.jimmie.test.groovy.use

/**
 * Created by jimmie on 2018/11/30.
 */
class AppGroovy2 {

    static main(args) {
        def closure = { param -> println "hello ${param}" }
        def pring = {
            if (args.length > 1) {
                println "${args[0]} ${args[1]}"
            }
        }
        closure("world")
        pring()
    }
}
