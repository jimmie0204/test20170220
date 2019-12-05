package com.jimmie.test.协程.quasar;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.SuspendExecution;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author jimmie
 * @create 2019-11-27 下午3:31
 */
public class CoroutineServer {

    public void run() throws IOException {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.configureBlocking(false);
        serverChannel.socket().bind(new InetSocketAddress("127.0.0.1", 8000));

        Selector selector = Selector.open();
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            selector.select();
            Iterator ite = selector.selectedKeys().iterator();

            while (ite.hasNext()) {
                SelectionKey key = (SelectionKey) ite.next();

                if (key.isAcceptable()) {
                    ServerSocketChannel s = (ServerSocketChannel) key.channel();
                    SocketChannel clientSocket = s.accept();
                    System.out.println("Got a new Connection");

                    clientSocket.configureBlocking(false);

                    SelectionKey newKey = clientSocket.register(selector, SelectionKey.OP_WRITE);

                    FiberConnection client = new FiberConnection(clientSocket, newKey);
                    client.start();
                    newKey.attach(client);

                    System.out.println("client waiting");
                } else if (key.isReadable()) {
                    FiberConnection client = (FiberConnection) key.attachment();
                    client.onRead();
                } else if (key.isWritable()) {
                    FiberConnection client = (FiberConnection) key.attachment();
                    client.onWrite();
                }

                ite.remove();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        CoroutineServer server = new CoroutineServer();
        server.run();
    }
}

class FiberConnection extends Fiber<Integer> {
    private SocketChannel socketChannel;
    private SelectionKey key;
    private ByteBuffer recvBuffer;

    public FiberConnection(SocketChannel socketChannel, SelectionKey key) {
        this.socketChannel = socketChannel;
        this.key = key;
        this.recvBuffer = ByteBuffer.allocate(32);
    }

    @Override
    protected Integer run() throws SuspendExecution, InterruptedException {
        int a = getInteger();
        int b = getInteger();
        if (b == 0)
            b += 1;

        sendResult(a / b);

        return 0;
    }

    private int getInteger() throws SuspendExecution {
        sendResult(0);

        Fiber.park();

        int res = 0;
        try {
            try {
                recvBuffer.clear();

                // read may fail even SelectionKey is readable
                // when read fails, the fiber should suspend, waiting for next
                // time the key is ready.
                int n = socketChannel.read(recvBuffer);
                while (n == 0) {
                    n = socketChannel.read(recvBuffer);
                }

                if (n == -1) {
                    close();
                    return 0;
                }

                System.out.println("received " + n + " bytes from client");
            } catch (IOException e) {
                e.printStackTrace();
            }

            recvBuffer.flip();
            res = getInt(recvBuffer);

            // when read ends, we are no longer interested in reading,
            // but in writing.
            key.interestOps(SelectionKey.OP_WRITE);
        } catch (Exception e) {
        }

        return res;
    }

    public void sendResult(int r) throws SuspendExecution {
        Fiber.park();
        try {
            try {
                recvBuffer.clear();
                recvBuffer.put(String.valueOf(r).getBytes());
                recvBuffer.flip();
                socketChannel.write(recvBuffer);

                key.interestOps(SelectionKey.OP_READ);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
        }
    }

    public int getInt(ByteBuffer buf) {
        int r = 0;
        while (buf.hasRemaining()) {
            r *= 10;
            r += buf.get() - '0';
        }

        return r;
    }

    public void close() {
        try {
            socketChannel.close();
            key.cancel();
        } catch (IOException e) {
        }
        ;
    }

    public void onRead() {
        this.unpark();
    }

    public void onWrite() {
        this.unpark();
    }
}