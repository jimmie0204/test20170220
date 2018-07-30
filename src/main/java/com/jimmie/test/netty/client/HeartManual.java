package com.jimmie.test.netty.client;/**
 * Created by Jimmie on 2018/7/30.
 */

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jimmie
 * @create 2018-07-30 23:24
 */

public class HeartManual {

    private volatile Boolean running = true;

    private AtomicInteger count = new AtomicInteger(0);

    public void start(ChannelHandlerContext ctx) {
        while (running) {
            System.out.println("发送心跳========");
            ctx.writeAndFlush(Unpooled.copiedBuffer("10000001".getBytes()));
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count.incrementAndGet() == 20) {
                running = false;
            }
        }
    }

    public void stop() {
        running = false;
        System.out.println("停止心跳===");
    }
}
