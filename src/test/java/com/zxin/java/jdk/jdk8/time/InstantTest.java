package com.zxin.java.jdk.jdk8.time;

import java.time.Instant;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author zxin
 *
 */
public class InstantTest {

	private static final Logger logger = LoggerFactory.getLogger(InstantTest.class);

	@Test
	public void test() {
		Instant instant = Instant.now();
		System.out.println(System.currentTimeMillis());
		System.out.println(instant.getEpochSecond());
		System.out.println(instant.getNano());
		System.out.println(instant.toString());
	}
}
