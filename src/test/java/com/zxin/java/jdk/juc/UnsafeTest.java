package com.zxin.java.jdk.juc;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.misc.Unsafe;

public class UnsafeTest {
	
	private static final Logger logger = LoggerFactory.getLogger(UnsafeTest.class);

	public static Unsafe unsafe;
	
	static{
		try {
			Field f = Unsafe.class.getDeclaredField("theUnsafe");
			f.setAccessible(true);
			unsafe = (Unsafe) f.get(null);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			logger.warn("", e);
		}
	}
	
	
	
	public static void main(String[] args) {
//		unsafe.
	}
	

	
	
}