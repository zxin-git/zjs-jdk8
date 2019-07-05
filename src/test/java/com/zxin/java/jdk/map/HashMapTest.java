package com.zxin.java.jdk.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executors;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HashMapTest {

	private static final int MAXIMUM_CAPACITY = 1 << 30;
	
	private static final Logger logger = LoggerFactory.getLogger(HashMapTest.class);
	
	
	@Test
	public void tableSizeForTest(){
		System.out.println(tableSizeFor(50));
	}

	
	static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
	
	
	/**
	 * 重排时，链表是反转顺序的
	 * size = 4 : table[1] = 1, 5 ,9
	 * size = 8 : table[1] = 9, 1; 并发： 1, 9, 1
	 * 
	 */
	@Test
	public void loopChainTest(){
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 5, 9, 13, 17));
		HashMap<Integer, Integer> hashMap = new HashMap<>(4);
		list.parallelStream().forEach((key) -> hashMap.put(key, key));
		hashMap.entrySet().forEach(System.out::println);
	}
	
	
	
	@Test
	public void hashTest(){
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
//		(h = key.hashCode()) ^ (h >>> 16)
		list.stream().map((key)-> key.hashCode() ^ (key.hashCode() >>> 16)).forEach(System.out::println);
	}
}
