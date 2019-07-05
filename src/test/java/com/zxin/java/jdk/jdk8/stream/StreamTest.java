package com.zxin.java.jdk.jdk8.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StreamTest {

	private static final Logger logger = LoggerFactory.getLogger(StreamTest.class);

	@Test
	public void test(){
		List<String> strList = Arrays.asList("1", "2", "3", "11");
		List<String> list = new ArrayList<>(strList);
		System.out.println(list.stream().map(Integer::valueOf).sorted().collect(Collectors.toList()).toString());
//		list.stream().flatMap(mapper);
	}
	
	@Test
	public void create(){
		//集合
		Collection<String> collection = Arrays.asList("1", "2", "3", "11");
		collection.stream();
		collection.parallelStream();
		
		//值
		Stream<String> stream1 = Stream.of("");
		Stream.of("1","2","3");
		
		//数组
		String[] array = {"1","2","3"};
		Arrays.stream(array);
		
		//文件
		try {
			Stream<String> stream = Files.lines(Paths.get("E:/stream.txt"));
			stream.forEach(System.out::println);
		} catch (IOException e) {
			logger.warn("", e);
		}
		
		//函数
		Stream<Integer> stream5 = Stream.generate(ThreadLocalRandom.current()::nextInt);
		Stream<Integer> stream6 = Stream.iterate(100, n -> n + 2);
		stream6.forEach(System.out::println);
		
	}
	
}
