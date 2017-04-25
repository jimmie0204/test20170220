package com.jimmie.test.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class HelloServerHandler extends ChannelInboundHandlerAdapter  {
	
	 @Override
	    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		 	ByteBuf result = (ByteBuf) msg;
			byte[] result1 = new byte[result.readableBytes()];
			// msg中存储的是ByteBuf类型的数据，把数据读取到byte[]中
			result.readBytes(result1);
			String resultStr = new String(result1);
			// 接收并打印客户端的信息
			System.out.println("上一个handler给我的信息是：Client said:" + resultStr);
			// 释放资源，这行很关键
			result.release();
			//或者
//			ReferenceCountUtil.release(encoded);

			// 向客户端发送消息
			String response = "I am ok!";
			// 在当前场景下，发送的数据必须转换成ByteBuf数组
			ByteBuf encoded = ctx.alloc().buffer(4 * response.length());
			encoded.writeBytes(response.getBytes());
			ctx.write(encoded);
			ctx.flush();

	    }
}
