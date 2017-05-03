package com.jimmie.test.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer{
	
	public void start() throws InterruptedException{
		
		EventLoopGroup boss = new NioEventLoopGroup();
		EventLoopGroup worker = new NioEventLoopGroup();
		EventLoopGroup myEx = new NioEventLoopGroup();
		try {
			
			ServerBootstrap server = new  ServerBootstrap();
			server.group(boss, worker).channel(NioServerSocketChannel.class)
			.option(ChannelOption.SO_BACKLOG, 2048).childOption(ChannelOption.SO_KEEPALIVE, true)
			.childHandler(new ChannelInitializer<SocketChannel>() {

				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					// 注册两个OutboundHandler，执行顺序为注册顺序的逆序，所以应该是OutboundHandler2 OutboundHandler1
					ch.pipeline().addLast(new OutboundHandler1());
					ch.pipeline().addLast(new OutboundHandler2());
					// 注册两个InboundHandler，执行顺序为注册顺序，所以应该是InboundHandler1 InboundHandler2
					ch.pipeline().addLast(new InboundHandler1());
					ch.pipeline().addLast(myEx,new InboundHandler2());
					ch.pipeline().addLast(new HelloServerHandler());
					
				}
			});
			
			ChannelFuture sync = server.bind(8000).sync();
			sync.channel().closeFuture().sync();
		} finally {
			worker.shutdownGracefully();
			boss.shutdownGracefully();
			
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("start!");
		new NettyServer().start();
		
	}
}