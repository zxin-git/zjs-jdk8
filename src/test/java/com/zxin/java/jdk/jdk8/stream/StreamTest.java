package com.zxin.java.jdk.jdk8.stream;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamTest {

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

		//合并
		Stream.concat(Stream.of("1","2","3"), Stream.of("0", "4"));
		
		//文件
		try {
			Stream<String> stream = Files.lines(Paths.get("E:/stream.txt"));
			stream.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//函数
		Stream<Integer> stream5 = Stream.generate(ThreadLocalRandom.current()::nextInt);
		Stream<Integer> stream6 = Stream.iterate(100, n -> n + 2);
		stream6.forEach(System.out::println);
	}

	@Test
	public void action() {

	}

	@Test
	public void finish() {
		Stream<String> stream = Stream.of("1","2","3");

		stream.forEach(System.out::println);
		long count = stream.count();
		List<String> list = stream.collect(Collectors.toList());
		String[] array = stream.toArray(String[]::new);


		Optional<String> maxItem = stream.max((s1, s2) -> s1.length() - s2.length());
		Optional<String> minItem = stream.min(String.CASE_INSENSITIVE_ORDER);

		Optional findFist = stream.findFirst();
		stream.findAny();

		boolean allMatch = stream.allMatch(String::isEmpty);
		stream.anyMatch(s -> s.length()>10);
		stream.noneMatch("a"::equals);

		//并行流时保持输出顺序严格一致
		stream.parallel().forEachOrdered(System.out::println);

		Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5);
		Optional<Integer> reduce = intStream.reduce((i1, i2) -> i1 + i2);
		Integer reduceHaveDefault =  intStream.reduce(100, (i1, i2) -> i1 - i2);	//init - i1 -i2

		String strReduce = intStream.reduce("init", (s, i) -> s + i, (s1, s2) -> null);
		ArrayList<String> strings = intStream.reduce(new ArrayList<String>(), (strList, i) -> {
			strList.add("s" + 1);
			return strList;
		}, (list1, list2) -> null);

		System.out.println(reduceHaveDefault);

	}

	@Test
	public void reduceType() {
		Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5);
		String parallel = intStream.parallel().reduce("init", (s, i) -> s + i, (s1, s2) -> null);
		intStream = Stream.of(1, 2, 3, 4, 5);
		String sequence = intStream.reduce("init", (s, i) -> s + i, (s1, s2) -> null);

		intStream = Stream.of(1, 2, 3, 4, 5);
		String parallelModify = intStream.parallel().reduce("", (s, i) -> s + i, (s1, s2) -> s1 + s2);
		System.out.println(Arrays.asList(parallel, sequence, parallelModify));
	}
}
