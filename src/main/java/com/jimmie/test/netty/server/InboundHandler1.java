package com.jimmie.test.netty.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class InboundHandler1 extends ChannelInboundHandlerAdapter {
	private static Log logger = LogFactory.getLog(InboundHandler1.class);

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		logger.info("InboundHandler1.channelRead: ctx :" + ctx+"==="+Thread.currentThread().getName());
		System.out.println("接受的上一个handler的信息为："+msg);
		
		ByteBuf result = (ByteBuf) msg;
		System.out.println("===================本次刻度长度："+result.readableBytes());
		byte[] result1 = new byte[result.readableBytes()];
		result.readBytes(result1);
		String resultStr = new String(result1);
		System.out.println("Client said:" + resultStr);
		ReferenceCountUtil.release(msg);
		
		System.out.println(msg);
		System.out.println(result);
		
		String newmsg1 = "in1";
		// 通知执行下一个InboundHandler
		ctx.fireChannelRead(newmsg1);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//		logger.info("InboundHandler1.channelReadComplete");
//		ctx.fireChannelReadComplete();
	}
}