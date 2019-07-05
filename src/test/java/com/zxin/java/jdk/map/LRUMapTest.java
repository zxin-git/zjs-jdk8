package com.zxin.java.jdk.map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LRUMapTest {

	private static final Logger logger = LoggerFactory.getLogger(LRUMapTest.class);

	@Test
	public void test() {
		LRUMap<String, String> lruMap = new LRUMap<>(5);
		for (int i = 0; i < 16; i++) {
			lruMap.put(i+"", i+"val");
		}
		lruMap.get("12");
		lruMap.get("13");
		lruMap.forEach((k, v)->{
			System.out.println(k+":"+v);
		});
	}

}
