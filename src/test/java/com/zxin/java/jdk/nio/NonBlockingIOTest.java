package com.zxin.java.jdk.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executors;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 非阻塞式IO
 * <p>ServerSocketChannel采用阻塞监听连接请求</p>
 * <p>每条连接对应的SocketChannel采用非阻塞模式</p>
 * <p>另增加单一线程负责轮询所有的SocketChannel <B>轮询的是通道</B></p>
 * 
 * @author zxin
 *
 */
public class NonBlockingIOTest {

	private static final Logger logger = LoggerFactory.getLogger(NonBlockingIOTest.class);

	@Test
	public void test(){
		
	}
	
	@Test
	public void server(){
		try {
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.bind(new InetSocketAddress("localhost", 15600));
//			serverSocketChannel.configureBlocking(false);
			
			CopyOnWriteArraySet<SocketChannel> socketChannels = new CopyOnWriteArraySet<>();
			Executors.newSingleThreadExecutor().execute(()->interact(socketChannels));
			
			int i = 0 ;
			while(true){
				SocketChannel socketChannel = serverSocketChannel.accept();
				socketChannel.configureBlocking(false);
				socketChannels.add(socketChannel);
				try {
					System.out.println("accept request:" + i++);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					logger.warn("", e);
				}
			}
		} catch (IOException e) {
			logger.warn("", e);
		}
	}
	
	/**
	 * 轮询所有的SocketChannel
	 * <p>执行相关的业务逻辑</p>
	 * @param socketChannels
	 */
	public void interact(CopyOnWriteArraySet<SocketChannel> socketChannels){
		int i = 0;
		while(true){
			if(socketChannels.size() > 0){
				socketChannels.forEach((channel)->{
					ChannelTest.read(channel);
				});
			}
			try {
				System.out.println("poll counter:" + i++);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				logger.warn("", e);
			}
		}
	}

	
}
