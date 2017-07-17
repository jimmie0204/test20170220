package com.jimmie.test.netty.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class InboundHandler2 extends ChannelInboundHandlerAdapter {
	private static Log	logger	= LogFactory.getLog(InboundHandler2.class);

	@Override
	// 读取Client发送的信息，并打印出来
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		logger.info("InboundHandler2.channelRead: ctx :"+ ctx+"==="+Thread.currentThread().getName());
		System.out.println("InboundHandler2接受的上一个handler的信息为："+msg);
		
//		result.release();
		ReferenceCountUtil.release(msg);
		
		String newmsg2 = "in2";
		ctx.fireChannelRead(newmsg2);

		//最后一个inboundHandler处理业务之后，开始往客户端写数据
		ctx.writeAndFlush(newmsg2);
//		ctx.fireChannelRead(resultStr);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//		logger.info("InboundHandler2.channelReadComplete");
//		ctx.fireChannelReadComplete();
	}

}