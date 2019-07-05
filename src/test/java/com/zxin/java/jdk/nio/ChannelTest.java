package com.zxin.java.jdk.nio;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChannelTest {

	private static final Logger logger = LoggerFactory.getLogger(ChannelTest.class);

	@Test
	public void test(){
		try {
			FileChannel fileChannel = FileChannel.open(Paths.get("E:/stream.txt"), 
					StandardOpenOption.WRITE, 
					StandardOpenOption.READ);
			read(fileChannel);
			write(fileChannel, "试试行不行".getBytes());
		} catch (IOException e) {
			logger.warn("", e);
		}
		
	}
	
	
	public static void read(ByteChannel channel){
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		try {
			for (int size = channel.read(buffer); size > 0; size = channel.read(buffer)) {
				System.out.println("### read byte size:" + size);
				System.out.println(new String(buffer.array(), "UTF-8"));
			}
		} catch (IOException e) {
			logger.warn("", e);
		}
	}
	
	
	public static void write(ByteChannel channel, byte[] bs){
		ByteBuffer buffer = ByteBuffer.wrap(bs);
		try {
			int size = channel.write(buffer);
		} catch (IOException e) {
			logger.warn("", e);
		}
	}
	
}
