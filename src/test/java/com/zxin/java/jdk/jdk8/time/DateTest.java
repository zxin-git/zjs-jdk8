package com.zxin.java.jdk.jdk8.time;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateTest {

	private static final Logger logger = LoggerFactory.getLogger(DateTest.class);

	@Test
	public void localDateTest(){
		LocalDate today = LocalDate.now();
		System.out.println(today);
		logger.info("{}", today.getMonthValue());
		LocalDate specificDate = LocalDate.of(2019, 10, 3);
		logger.info("{}", specificDate);
	}
	
	@Test
	public void localTimeTest(){
		LocalTime time = LocalTime.now();
		System.out.println(time);
		time = LocalTime.of(22, 10, 56);
		System.out.println(time);
		time = time.plusHours(3);
		System.out.println(time);
	}
	
	
	@Test
	public void clockTets(){
//		Clock clock = Clock.systemUTC();
		Clock clock = Clock.systemDefaultZone();
		
	}
	
	@Test
	public void zoneTest(){
	}
}
