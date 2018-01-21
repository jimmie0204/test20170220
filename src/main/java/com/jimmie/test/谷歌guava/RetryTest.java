package com.jimmie.test.谷歌guava;
/**
 * Created by jimmie on 2018/1/17.
 */

import com.github.rholder.retry.*;
import com.google.common.base.Predicates;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author jimmie
 * @create 2018-01-17 下午5:41
 */

public class RetryTest {
    public static void main(String[] args){

        Callable<Integer> task = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 2;
            }
        };

        Retryer<Integer> retryer = RetryerBuilder.<Integer>newBuilder()
                .retryIfResult(Predicates.<Integer>isNull())
                .retryIfResult(Predicates.equalTo(2))
                .retryIfExceptionOfType(IOException.class)
                .withStopStrategy(StopStrategies.stopAfterAttempt(3))
                .withWaitStrategy(WaitStrategies.fixedWait(300, TimeUnit.MILLISECONDS))
                .build();
        try {
            retryer.call(task);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (RetryException e) {
            e.printStackTrace();
        }
    }
}
