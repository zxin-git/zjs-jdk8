package com.zxin.java.jdk.jdk8.time;

import java.time.Duration;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 时间间隔
 * 
 * @author zxin
 *
 */
public class DurationTest {

	private static final Logger logger = LoggerFactory.getLogger(DurationTest.class);

	@Test
	public void test() {
		Duration duration = Duration.ofDays(3);
		System.out.println(duration.toDays());
		System.out.println(duration.toString());
		System.out.println(duration.toMinutes());
	}
}
