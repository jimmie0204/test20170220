package com.jimmie.test.线程.sync;/**
 * Created by jimmie on 2018/6/11.
 */

import org.junit.After;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jimmie
 * @create 2018-06-11 下午3:51
 */

public class SyncMainTest {


    Parent parent = new Parent();

    ChildA childA = new ChildA();

    ExecutorService executorService = Executors.newFixedThreadPool(5);


    @Test
    public void test(){


        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    parent.print();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

//        executorService.submit(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    parent.print();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        executorService.submit(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    childA.print();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    childA.childPrint();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    childA.print();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @After
    public void after(){
        executorService.shutdown();
    }

    @Test
    public void test2() throws IOException {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    childA.print2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    childA.print2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.in.read();

    }

    @Test
    public void test3() throws IOException {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    parent.print();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    childA.print();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println(childA.obj==parent.obj);//当然是false，childA和parent两个对象，成员变量当然不同
        System.in.read();

    }


}
