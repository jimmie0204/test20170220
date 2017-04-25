package com.jimmie.test.netty.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

public class OutboundHandler1 extends ChannelOutboundHandlerAdapter {
	private static Log	logger	= LogFactory.getLog(OutboundHandler1.class);
	@Override
	// 向client发送消息
	public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
		logger.info("OutboundHandler1.write");
		System.out.println("接受的上一个handler的信息为："+msg);
		String response = "I am ok!";
		ByteBuf encoded = ctx.alloc().buffer(4 * response.length());
		encoded.writeBytes(response.getBytes());
		ctx.write(encoded);
//		ReferenceCountUtil.release(encoded); //不需要释放，flush的时候会释放！！
		ctx.flush();
		
	}
	
	
}