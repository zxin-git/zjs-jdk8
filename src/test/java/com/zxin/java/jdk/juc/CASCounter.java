package com.zxin.java.jdk.juc;

import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CASCounter {

	private static final Logger logger = LoggerFactory.getLogger(CASCounter.class);

	private volatile int counter = 0;
	
	private static long offset;

	private static volatile AtomicInteger c = new AtomicInteger(0);
	
	static{
		try {
			offset = UnsafeTest.unsafe.objectFieldOffset(CASCounter.class.getDeclaredField("counter"));
		} catch (NoSuchFieldException | SecurityException e) {
			logger.warn("", e);
		}
	}
	
	public void increment(){
		int before = counter;
		while (! UnsafeTest.unsafe.compareAndSwapInt(this, offset, before, before + 1)) {
			before = counter;
			System.out.println(counter +" cas   " + Thread.currentThread().getName()+"  "+c.incrementAndGet());
			
		}
	}
	
	@Test
	public void test() {
		for (int i = 0; i < 10; i++) {
			Executors.newCachedThreadPool().execute(()->increment());
		}
		System.out.println(counter +"end");
	}
	
}
