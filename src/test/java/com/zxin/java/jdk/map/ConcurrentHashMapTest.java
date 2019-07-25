package com.zxin.java.jdk.map;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConcurrentHashMapTest {

	private static final Logger logger = LoggerFactory.getLogger(ConcurrentHashMapTest.class);

	
	@Test
	public void performanceTest(){
		ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
		Hashtable<Integer, Integer> hashtable = new Hashtable<>();
		Map<Integer, Integer> syncMap = Collections.synchronizedMap(new HashMap<>());
		
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 0x00ffffff; i++) {	//0x7fffffff
			list.add(i);
		}
		
//		testMap(syncMap, list);
		testMap(concurrentHashMap, list);
		System.out.println("-------------预热完毕-------------");
		for (int i = 10; i > 1; i--) {
			System.out.println("-------------------------");
			List<Integer> alist = list.subList(0, list.size()/i);
			testMap(syncMap, alist);
			testMap(concurrentHashMap, alist);
			testMap(hashtable, alist);
		}
	}

	<K> void testMap(Map<K, K> map, List<K> list){
		Duration duration = Duration.ofMillis(System.currentTimeMillis());
		list.parallelStream().forEach((i) ->{
			map.put(i, i);
//			System.out.println(Thread.currentThread().getName() + " :" +i);
		});
		Duration d = Duration.ofMillis(System.currentTimeMillis()).minus(duration);
		System.out.println(map.size() + ":" +d.toMillis());
	}
	
	
	@Test
	public void test() {
		Map<Integer, String> map = new ConcurrentHashMap<>();
		map.put(1, "2");
	}
	
	
	
}
