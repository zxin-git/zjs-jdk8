package com.zxin.java.jdk.nio;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ByteChannel;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Set;
import java.util.concurrent.Executors;

/**
 * IO多路复用
 * <p>已经select有数据的通道</p>
 * <p>循环获取通道数据,必有返回</p>
 * 
 * @author zxin
 *
 */
public class MutiplexIOTest {

	private static final Logger logger = LoggerFactory.getLogger(MutiplexIOTest.class);

	public void test(){
//		serverSocketChannel.register(selector, SelectionKey.OP_READ);
//		int keys = selector.select();
//		while (true) {
//			if (readyChannels == 0)
//				continue;
//			Set<SelectionKey> selectedKeys = selector.selectedKeys();
//			Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
//			while (keyIterator.hasNext()) {
//				SelectionKey key = keyIterator.next();
//				if (key.isAcceptable()) {
//					// a connection was accepted by a ServerSocketChannel.
//				} else if (key.isConnectable()) {// 连接就绪
//					// a connection was established with a remote server.
//				} else if (key.isReadable()) {// 读就绪
//					// a channel is ready for reading
//				} else if (key.isWritable()) {// 写就绪
//					// a channel is ready for writing
//				}
//				keyIterator.remove();
//			}
//		}
//		System.out.println(keys);
	}
	
	@Test
	public void server(){
		try {
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.bind(new InetSocketAddress("localhost", 15600));
			serverSocketChannel.configureBlocking(false);
			
			Selector acceptSelector = Selector.open();
			serverSocketChannel.register(acceptSelector, SelectionKey.OP_ACCEPT);
			
			Selector selector = Selector.open();
			serverSocketChannel.register(selector, SelectionKey.OP_CONNECT);
			Executors.newSingleThreadExecutor().execute(()->interact(selector));
			accept(acceptSelector, selector);
			
//			int i = 0 ;
//			while(true){
//				SocketChannel socketChannel = serverSocketChannel.accept();
////				socketChannel.configureBlocking(false);
//				try {
//					System.out.println("accept request:" + i++);
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					logger.warn("", e);
//				}
//			}
			
			
		} catch (IOException e) {
			logger.warn("", e);
		}
	}
	
	public void interact(Selector selector){
		int readyKeysNum = 0;
		int i = 0;
		try {
			while((readyKeysNum = selector.select()) > 0){
				Set<SelectionKey> readyKeys = selector.selectedKeys();
				readyKeys.stream().forEach((key)->{
					ChannelTest.read((ByteChannel)key.channel());
				});
				try {
					System.out.println("select counter:" + i++);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					logger.warn("", e);
				}
				
			}
		} catch (IOException e) {
			logger.warn("", e);
		}
		
	}
	
	public void accept(Selector acceptSelector, Selector readSelector){
		int readyKeysNum = 0;
		int i = 0;
		try {
			while((readyKeysNum = acceptSelector.select()) > 0){
				Set<SelectionKey> readyKeys = acceptSelector.selectedKeys();
				readyKeys.forEach((key)->{
					try {
						key.channel().configureBlocking(false).register(readSelector, SelectionKey.OP_CONNECT, SelectionKey.OP_READ);
					} catch (ClosedChannelException e) {
						logger.warn("", e);
					} catch (IOException e) {
						logger.warn("", e);
					}
				});
				try {
					System.out.println("accept counter:" + i++);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					logger.warn("", e);
				}
				
			}
		} catch (IOException e) {
			logger.warn("", e);
		}
	}
	
	
}
