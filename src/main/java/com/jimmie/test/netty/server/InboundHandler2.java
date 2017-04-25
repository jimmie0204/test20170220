package com.jimmie.test.netty.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class InboundHandler2 extends ChannelInboundHandlerAdapter {
	private static Log	logger	= LogFactory.getLog(InboundHandler2.class);

	@Override
	// 读取Client发送的信息，并打印出来
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		logger.info("InboundHandler2.channelRead: ctx :"+ ctx+"==="+Thread.currentThread().getName());
		System.out.println("接受的上一个handler的信息为："+msg);
		ByteBuf result = (ByteBuf) msg;
		byte[] result1 = new byte[result.readableBytes()];
		result.readBytes(result1);
		String resultStr = new String(result1);
		System.out.println("Client said:" + resultStr);
		result.release();
		
		//最后一个inboundHandler处理业务之后，开始往客户端写数据
		ctx.write(msg);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		logger.info("InboundHandler2.channelReadComplete");
		ctx.fireChannelReadComplete();
	}

}