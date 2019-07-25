package com.zxin.java.jdk.juc.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongAdderTest {

	private static final Logger logger = LoggerFactory.getLogger(LongAdderTest.class);

	@Test
	public void test(){
		LongAdder longAdder = new LongAdder();
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 100; i++) {
			final int a = i;
			executorService.execute(()->{
				longAdder.add(1);
				System.out.println(longAdder.longValue());
			});
		}
	}
}
