package com.zxin.java.jdk.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 演示IO模型的SocketServer
 * 
 * @author zxin
 *
 */
public class SocketServerTest {

	private static final Logger logger = LoggerFactory.getLogger(SocketServerTest.class);

	@Test
	public void server(){
		try(ServerSocket serverSocket = new ServerSocket(8900);) {
			int i = 0;
			while(true){
					Socket socket = serverSocket.accept();
					Executors.newCachedThreadPool().execute(() -> read(socket));
				try {
					Thread.sleep(1000);
					System.out.println(i++);
				} catch (InterruptedException e) {
					logger.warn("", e);
				}
			}
		} catch (IOException e) {
			logger.warn("", e);
		}
	}
	
	
	public static void read(Socket socket){
		
		try (BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(socket.getInputStream(),"UTF-8"))){
			String str = null;
			while((str = bufferedReader.readLine()) != null){
				System.out.println(str);
			}
			
		} catch (Exception e) {
			logger.warn("", e);
		}
	}
	
	public static void write(Socket socket){
		
		try (BufferedWriter bufferedWriter = new BufferedWriter(
				new OutputStreamWriter(socket.getOutputStream(),"UTF-8"))){
			bufferedWriter.write(ThreadLocalRandom.current().nextInt(100, 900)+"");
			
		} catch (Exception e) {
			logger.warn("", e);
		}
	}
	
}
