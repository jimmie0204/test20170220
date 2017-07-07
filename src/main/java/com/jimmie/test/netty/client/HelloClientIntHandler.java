package com.jimmie.test.netty.client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class HelloClientIntHandler extends ChannelInboundHandlerAdapter {
	private static Log logger = LogFactory.getLog(HelloClientIntHandler.class);

	// 接收server端的消息，并打印出来
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		logger.info("HelloClientIntHandler.channelRead");
		ByteBuf result = (ByteBuf) msg;
		byte[] result1 = new byte[result.readableBytes()];
		result.readBytes(result1);
		System.out.println("Server said:" + new String(result1));
		result.release();
	}

	// 连接成功后，向server发送消息
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		logger.info("HelloClientIntHandler.channelActive");
		byte[] req = ("In this chapter you general, we recommend Java Concurrency in Practice by Brian Goetz. His book w"  
                + "ill give We’ve reached an exciting point—in the next chapter we’ll discuss bootstrapping, the process "  
                + "of configuring and connecting all of Netty’s components to bring your learned about threading models in ge"  
                + "neral and Netty’s threading model in particular, whose performance and consistency advantages we discuss"  
                + "ed in detail In this chapter you general, we recommend Java Concurrency in Practice by Brian Goetz. Hi"  
                + "s book will give We’ve reached an exciting point—in the next chapter we’ll discuss bootstrapping, the"  
                + " process of configuring and connecting all of Netty’s components to bring your learned about threading "  
                + "models in general and Netty’s threading model in particular, whose performance and consistency advantag"  
                + "es we discussed in detailIn this chapter you general, we recommend Java Concurrency in Practice by Bri"  
                + "an Goetz. His book will give We’ve reached an exciting point—in the next chapter;the counter is: 1 2222"  
                + "sdsa ddasd asdsadas dsadasdas" + System.getProperty("line.separator")).getBytes();  
		
		ByteBuf encoded = ctx.alloc().buffer(req.length);
		encoded.writeBytes(req);
	/*	String msg = "Are you ok?";
		ByteBuf encoded = ctx.alloc().buffer(4 * msg.length());
		encoded.writeBytes(msg.getBytes());*/
		ctx.write(encoded);
		ctx.flush();
	}
}