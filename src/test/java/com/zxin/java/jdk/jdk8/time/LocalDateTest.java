package com.zxin.java.jdk.jdk8.time;

import java.time.LocalDate;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalDateTest {

	private static final Logger logger = LoggerFactory.getLogger(LocalDateTest.class);
	
	@Test
	public void test(){
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate.getYear());
		System.out.println(localDate.getMonthValue());
		System.out.println(localDate.getDayOfMonth());
		System.out.println(localDate.toString());
	}

}
