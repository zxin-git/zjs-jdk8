package com.zxin.java.jdk.util.collection;

import java.util.concurrent.ArrayBlockingQueue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueueTest {

	private static final Logger logger = LoggerFactory.getLogger(QueueTest.class);

	@Test
	public void addTest() {
		ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(1);
		queue.add("1");
//		queue.add("2");	//java.lang.IllegalStateException: Queue full
		System.out.println(queue.offer("2")); //false
	}
	
	@Test
	public void removeTest() {
		ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(1);
//		queue.remove(); //java.util.NoSuchElementException
		System.out.println(queue.poll());	//null
	}
	
	@Test
	public void elementTest() {
		ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(1);
		queue.element(); //java.util.NoSuchElementException
//		System.out.println(queue.peek());	//null
	}
	
	@Test
	public void streamTest(){
		ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(1);
		queue.stream().forEach(System.out::println);
	}
}
