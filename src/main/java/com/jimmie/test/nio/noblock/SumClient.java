package com.jimmie.test.nio.noblock;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.SocketChannel;

/**
 * SumClient.java
 * 
 * 
 * Created: Thu Nov 06 11:26:06 2003
 * 
 * @author starchu1981
 * @version 1.0
 */
public class SumClient {
	private ByteBuffer _buffer = ByteBuffer.allocate(8);
	private IntBuffer _intBuffer;
	private SocketChannel _channel;

	public SumClient() {
		_intBuffer = _buffer.asIntBuffer();
	} // SumClient constructor

	public int getSum(int first, int second) {
		int result = 0;
		try {
			_channel = connect();
			sendSumRequest(first, second);
			result = receiveResponse();
		} catch (IOException e) {
			System.err.println(e.toString());
		} finally {
			if (_channel != null) {
				try {
					_channel.close();
				} catch (IOException e) {
				}
			}
		}
		return result;
	}

	private SocketChannel connect() throws IOException {
		InetSocketAddress socketAddress = new InetSocketAddress("localhost",
				10201);
		return SocketChannel.open(socketAddress);
	}

	private void sendSumRequest(int first, int second) throws IOException {
		_buffer.clear();
		_intBuffer.put(0, first);
		_intBuffer.put(1, second);
		_channel.write(_buffer);
		System.out.println("发送加法请求 " + first + "+" + second);
	}

	private int receiveResponse() throws IOException {
		_buffer.clear();
		_channel.read(_buffer);
		return _intBuffer.get(0);
	}

	public static void main(String[] args) {
		SumClient sumClient = new SumClient();
		System.out.println("加法结果为 :" + sumClient.getSum(100, 324));
	}
}