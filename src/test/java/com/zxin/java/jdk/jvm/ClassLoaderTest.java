package com.zxin.java.jdk.jvm;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * sun.misc.Launcher
 * @author zxin
 *
 */
public class ClassLoaderTest {

	private static final Logger logger = LoggerFactory.getLogger(ClassLoaderTest.class);

	@Test
	public void test() throws Exception {
		Object obj = new Object();
        System.out.println(obj.getClass());
        System.out.println(obj.getClass().getClassLoader());
        System.out.println(ClassLoaderTest.class.getClassLoader());
        Class.forName("sss");
	}
}
