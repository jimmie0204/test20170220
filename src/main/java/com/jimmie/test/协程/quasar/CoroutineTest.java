package com.jimmie.test.协程.quasar;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.SuspendExecution;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author jimmie
 * @create 2019-11-27 下午2:23
 */

public class CoroutineTest {
    public static void main(String[] args) {
        Fiber fiberA = new FiberTask("hello");
        Fiber fiberB = new FiberTask("world");
        fiberA.start();
        fiberB.start();
        try {
            fiberA.join();
            fiberB.join();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class FiberTask extends Fiber<Integer> {
    private String msg;

    public FiberTask(String msg) {
        this.msg = msg;
    }

    @Override
    protected Integer run() throws SuspendExecution, InterruptedException {
        for (int i = 0; i < 5; i++) {
            System.out.println(msg);
            Fiber.park(1000, TimeUnit.MILLISECONDS);
        }
        return 0;
    }
}
