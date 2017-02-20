package com.jimmie.test.nio.noblock;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Set;

/**
 * SumServer.java
 * 
 * 
 * Created: Thu Nov 06 11:41:52 2003
 * 
 * @author starchu1981
 * @version 1.0
 */
public class SumServer {
	private ByteBuffer _buffer = ByteBuffer.allocate(8);
	private IntBuffer _intBuffer = _buffer.asIntBuffer();
	private SocketChannel _clientChannel = null;
	private ServerSocketChannel _serverChannel = null;

	public void start() {
		try {
			openChannel();
			waitForConnection();
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}

	private void openChannel() throws IOException {
		_serverChannel = ServerSocketChannel.open();
		_serverChannel.socket().bind(new InetSocketAddress(10000));
		_serverChannel.configureBlocking(false);// 设置成为非阻塞模式
		System.out.println("服务器通道已经打开");
	}

	/*
	 * private void waitForConnection() throws IOException { while (true) {
	 * _clientChannel = _serverChannel.accept(); if (_clientChannel != null) {
	 * System.out.println("新的连接加入"); processRequest(); _clientChannel.close(); }
	 * } }
	 */

	private void waitForConnection() throws Exception {
		
		Selector acceptSelector = SelectorProvider.provider().openSelector();
		/*
		 * 在服务器套接字上注册selector并设置为接受accept方法的通知。
		 * 这就告诉Selector，套接字想要在accept操作发生时被放在ready表 上，因此，允许多元非阻塞I/O发生。
		 */
		
		
		SelectionKey acceptKey = _serverChannel.register(acceptSelector,
				SelectionKey.OP_ACCEPT);
		int keysAdded = 0;

		/* select方法在任何上面注册了的操作发生时返回 */
		while ((keysAdded = acceptSelector.select()) > 0) {//select()方法阻塞
			System.out.println("进入while=====");//单线程处理，如果一个事件处理时间过长，其他事件等待
//			Thread.sleep(10000);
			
			// 某客户已经准备好可以进行I/O操作了，获取其ready键集合
			Set<SelectionKey> readyKeys = acceptSelector.selectedKeys();
			Iterator<SelectionKey> i = readyKeys.iterator();
			// 遍历ready键集合，并处理加法请求
			while (i.hasNext()) {
				SelectionKey key =  i.next();
				i.remove();
				
				 if (key.isConnectable()) {
		                ((SocketChannel)key.channel()).finishConnect();
		            }
		            if (key.isAcceptable()) {
		                // accept connection
		            	ServerSocketChannel nextReady = (ServerSocketChannel) key
								.channel();
						// 接受加法请求并处理它
						_clientChannel = nextReady.accept();
						processRequest();
		            }
		            if (key.isReadable()) {
		                // ...read messages...
		            }
			
			}
		}
	}

	private void processRequest() throws IOException {
		_buffer.clear();
		_clientChannel.read(_buffer);
		int result = _intBuffer.get(0) + _intBuffer.get(1);
		_buffer.flip();
		_buffer.clear();
		_intBuffer.put(0, result);
		_clientChannel.write(_buffer);
	}

	public static void main(String[] args) {
		new SumServer().start();
	}
}