package com.jimmie.test.netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class HelloClientIntHandler3 extends ChannelInboundHandlerAdapter {
    private static Log logger = LogFactory.getLog(HelloClientIntHandler3.class);

    public HeartManual heart = new HeartManual();

    private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

    private AtomicInteger count = new AtomicInteger(0);

    // 接收server端的消息，并打印出来
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("HelloClientIntHandler.channelRead");
        ByteBuf result = (ByteBuf) msg;
        while (result.isReadable()){
            byte b = result.readByte();
            System.out.println("Server said=====:" + b);
        }
        result.release();
    }

    // 连接成功后，向server发送消息
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String REQ = "1000000";
        /*for (int i = 1; i < 2; i++) {
            ctx.writeAndFlush(Unpooled.copiedBuffer((REQ + i).getBytes()));
        }*/

        System.out.println("开始发送心跳了==========25秒后执行关闭心跳");

        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("发送心跳========");
                ctx.writeAndFlush(Unpooled.copiedBuffer("10000001".getBytes()));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (count.incrementAndGet() == 20) {
                    System.out.println("=====发送end===========");
                    executorService.shutdown() ;
                }
            }
        },5,1,TimeUnit.SECONDS);



    }

}