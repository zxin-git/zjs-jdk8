package com.zxin.java.jdk.jdk8.time;

import java.time.LocalDateTime;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalDateTimeTest {

	private static final Logger logger = LoggerFactory.getLogger(LocalDateTimeTest.class);

	@Test
	public void test(){
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime.toString());
		System.out.println(localDateTime.toLocalDate().toString());
		System.out.println(localDateTime.toLocalTime().toString());
	}
	
}
