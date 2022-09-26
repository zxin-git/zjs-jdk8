package com.zxin.java.jdk.util.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author zxin
 *
 */
public class ListTest {

	private static final Logger logger = LoggerFactory.getLogger(ListTest.class);

	@Test
	public void replaceAllTest() {
//		List<Integer> list = Arrays.asList(1, 12, 34, 23);	
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 12, 34, 23));
		list.replaceAll((t) -> t%10);
		
		list.forEach(System.out::println);
	}
	
	
	/**
	 * 删除第一个元素
	 */
	@Test
	public void removeTest() {
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 1, 2, 2));
		list.remove(1);
		list.remove(2);
		
		list.forEach(System.out::println);
	}

	@Test
	public void removeObjectTest(){
		List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
		list.remove("b");
		list.forEach(System.out::println);
	}
	
	/**
	 * 添加至index后， 原先的右移
	 */
	@Test
	public void addAllTest() {
		List<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
		List<Integer> adds = new ArrayList<>(Arrays.asList(11, 12, 13));
//		list.addAll(adds);
		list.addAll(2, adds);
		list.forEach(System.out::println);
	}
	
	/**
	 * 数组越界和链表越界
	 * <p>上下越界</p>
	 */
	@Test
	public void indexOutTest(){
		List<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
		list.set(20, 1);
//		list.set(-1, 1);
	}
	
}
