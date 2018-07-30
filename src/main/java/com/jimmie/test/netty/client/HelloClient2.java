package com.jimmie.test.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class HelloClient2 {
	
	private Channel channel;
	
	public void connect(String host, int port) throws Exception {
		EventLoopGroup workerGroup = new NioEventLoopGroup();

		try {
			Bootstrap b = new Bootstrap();
			b.group(workerGroup).channel(NioSocketChannel.class).option(ChannelOption.SO_KEEPALIVE, true)
			.handler(new ChannelInitializer<SocketChannel>() {
				@Override
				public void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast(new HelloClientIntHandler3());
				}
			});

			// Start the client.
			ChannelFuture f = b.connect(host, port).sync();

			channel = f.channel();
			Thread.sleep(1000000);
			// Wait until the connection is closed.
			channel.closeFuture().sync();

			System.out.println("over.....");
		} finally {
			workerGroup.shutdownGracefully();
		}

	}

	//netty作者推荐的重连方式
	//https://stackoverflow.com/questions/19739054/whats-the-best-way-to-reconnect-after-connection-closed-in-netty

/*	private void doConnect() {
		Bootstrap b = ...;
		b.connect().addListener((ChannelFuture f) -> {
			if (!f.isSuccess()) {
				long nextRetryDelay = nextRetryDelay(...);
				f.channel().eventLoop().schedule(nextRetryDelay, ..., () -> {
					doConnect();
				}); // or you can give up at some point by just doing nothing.
			}
		});
	}*/

	public static void main(String[] args) throws Exception {
		HelloClient2 client = new HelloClient2();
		client.connect("127.0.0.1", 10201);
	}
}