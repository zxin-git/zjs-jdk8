package com.zxin.java.jdk.jdk8.func;

import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 方法引用
 * 	<p> 四种方法的引用方式</p>
 * 	<ul>
 *		<li>构造器</li>
 *		<li>静态方法</li>
 *		<li>普通实例方法</li>
 *		<li>特定对象方法</li>
 *	</ul>
 * @author zxin
 *
 */
public class FunctionRefTest {

	private static final Logger logger = LoggerFactory.getLogger(FunctionRefTest.class);

	@Test
	public void test() {
		Supplier<String> constructorSupplier = String::new;
		Function<String, String> constructorFunction = String::new;
		
		Function<Integer, String> staticFunction = String::valueOf;
		
		Function<String, String> instanceFunction = String::toUpperCase;
		
		Supplier<String> objectSupplier = "sss"::toUpperCase;
	}
	
}
