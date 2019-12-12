package com.zxin.java.jdk.jdk8.func;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.*;

public class FunctionTest {

	private static final Logger logger = LoggerFactory.getLogger(FunctionTest.class);

	/**
	 * 判断
	 */
	@Test
	public void predicate(){
//		Predicate<String> predicate = (str) -> str.isEmpty();
		Predicate<String> predicate = String::isEmpty;
		System.out.println(predicate.test("pred"));
	}
	
	/**
	 * 消费
	 */
	@Test
	public void consumer(){
//		Consumer<String> consumer = (str) -> System.out.println(str);
		Consumer<String> consumer = System.out::println;
		consumer.accept("cons");
	}
	
	/**
	 * 生产
	 */
	@Test
	public void supplier(){
//		Supplier<String> supplier = () -> "supp".toUpperCase();
		Supplier<String> supplier = "supp"::toUpperCase;
		System.out.println(supplier.get());
	}
	
	/**
	 * 功能
	 */
	@Test
	public void function(){
		Function<String, Integer> function = Integer::valueOf;
		System.out.println(function.apply("330"));
	}

	/**
	 * 功能
	 */
	@Test
	public void unaryOperator(){
//		Runnable runnable = () -> System.out.println("a");
//		UnaryOperator unaryOperator = (UnaryOperator<Integer>) x -> x + 1;
		UnaryOperator unaryOperator =  x -> x;
		System.out.println(unaryOperator.apply(1));
	}

	/**
	 * 双入参函数
	 */
	@Test
	public void biFunction(){
		BiFunction<Integer, Integer, String> biFunction = (a, b) -> a + b +"";
	}
}
