package com.zxin.java.jdk.jdk8.time;

import java.time.Period;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日期间隔
 * <p></p>
 * 
 * @author zxin
 *
 */
public class PeriodTest {

	private static final Logger logger = LoggerFactory.getLogger(PeriodTest.class);

	@Test
	public void test(){
		Period period = Period.ofYears(3);
		System.out.println(period.toTotalMonths());
		System.out.println(period.toString());
		
//		Period period = Period.ofMonths(1);
//		System.out.println(period.minusDays(10));
//		System.out.println(period.toString());
	}
}
