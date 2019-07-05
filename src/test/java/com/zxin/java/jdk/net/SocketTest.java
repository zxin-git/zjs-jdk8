package com.zxin.java.jdk.net;

import java.io.IOException;
import java.net.Socket;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SocketTest {

	private static final Logger logger = LoggerFactory.getLogger(SocketTest.class);

	@Test
	public void socket(){
		try(Socket socket = new Socket("127.0.0.1", 8900);) {
			SocketServerTest.write(socket);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				logger.warn("", e);
			}
		} catch (IOException e) {
			logger.warn("", e);
		}
	}
	
}
