package com.zxin.java.jdk.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author zxin
 *
 */
public class SpliteratorTest {

	private static final Logger logger = LoggerFactory.getLogger(SpliteratorTest.class);

	
	public void test(){
		List<String> list = new ArrayList<>(Arrays.asList("1", "12", "34", "23"));
		
		Spliterator<String> spliterator = list.spliterator();
		
		
	}
}
