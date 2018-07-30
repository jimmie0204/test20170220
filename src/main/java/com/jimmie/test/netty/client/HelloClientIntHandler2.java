package com.jimmie.test.netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HelloClientIntHandler2 extends ChannelInboundHandlerAdapter {
    private static Log logger = LogFactory.getLog(HelloClientIntHandler2.class);

    // 接收server端的消息，并打印出来
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("HelloClientIntHandler.channelRead");
        ByteBuf result = (ByteBuf) msg;
        byte b = result.readByte();
        System.out.println("Server said=====:" + b);
        result.release();
    }

    // 连接成功后，向server发送消息
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String REQ = "1000000";
        for (int i = 0; i < 1; i++) {
            ctx.writeAndFlush(Unpooled.copiedBuffer((REQ + i).getBytes()));
        }
    }

}