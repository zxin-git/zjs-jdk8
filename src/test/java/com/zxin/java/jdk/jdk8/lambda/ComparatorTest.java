package com.zxin.java.jdk.jdk8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComparatorTest {

	private static final Logger logger = LoggerFactory.getLogger(ComparatorTest.class);

	@Test
	public void test() {
		List<String> list = Arrays.asList("1", "2", "3", "11");
		list.sort(Comparator.comparing(String::toString));
		list.sort(Comparator.comparing(String::valueOf));
		System.out.println();
	}
	
	public void func() {
		Predicate<String> predicate = (s)-> {return s.isEmpty();};
		Predicate<String> predicate1 = (s)-> s.isEmpty();
	}
	
	@Test
	public void stream(){
		List<String> stringList = Arrays.asList("a1", "a2", "b1", "c1", "c2", "c4", "c3");

//		stringList.stream()
//		        // 筛选出以c开头的字符串
//		        .filter(s -> s.startsWith("c"))
//		        // 将刚刚以c开头的字符串转为大写
//		        .map(String::toUpperCase)
//		        // 排序
//		        .sorted()
//		        // 循环遍历
//		        .forEach(System.out::println);
		stringList.stream().parallel().forEach((s)->{
			System.out.println(s + "," + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				logger.warn("", e);
			}
		});
		System.out.println("end");
	}
}
