package com.jimmie.test.netty.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class InboundHandler1 extends ChannelInboundHandlerAdapter {
	private static Log logger = LogFactory.getLog(InboundHandler1.class);

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		logger.info("InboundHandler1.channelRead: ctx :" + ctx);
		System.out.println("接受的上一个handler的信息为："+msg);
		// 通知执行下一个InboundHandler
		ctx.fireChannelRead(msg);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		logger.info("InboundHandler1.channelReadComplete");
		ctx.fireChannelReadComplete();
	}
}