package com.jimmie.test.netty.server;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

public class OutboundHandler2 extends ChannelOutboundHandlerAdapter {
	private static Log	logger	= LogFactory.getLog(OutboundHandler2.class);
	
	/**
	 * msg是上一个handler传过来的信息
	 */
	@Override
	public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
		logger.info("OutboundHandler2.write==="+Thread.currentThread().getName());
		System.out.println("接受的上一个handler的信息为："+msg);
		/*String response = "我他妈先发一个I am ok!";
		ByteBuf encoded = ctx.alloc().buffer(4 * response.length());
		encoded.writeBytes(response.getBytes());
		ctx.writeAndFlush(encoded);//第一次往下传递
*/		
	
		/*TimeUnit.SECONDS.sleep(5);
		
		response = "fuck !!!";
		ByteBuf otherMsg = ctx.alloc().buffer(4 * response.length());
		otherMsg.writeBytes(response.getBytes());
		ctx.writeAndFlush(otherMsg);*/
		
		// 执行下一个OutboundHandler
		ctx.write(msg, promise);//第二次往下传递
	}
}