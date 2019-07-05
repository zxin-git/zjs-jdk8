package com.zxin.java.jdk.collection;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CodeTest {

	private static final Logger logger = LoggerFactory.getLogger(CodeTest.class);

	/**
	 * 补码
	 * @return
	 */
	public String complement(int i){
		if(i > 0){
			String s = Integer.toBinaryString(i);
			StringBuilder builder = new StringBuilder();
			for (int j = 0; j < (32 - s.length()); j++) {
				builder.append("0");
			}
			return builder.append(s).toString();
		}
		return Integer.toBinaryString(i);
	}
	
	/**
	 * 反码
	 * @return
	 */
	public String minus(int i){
		String s = Integer.toBinaryString(i);
		if(i<0){
			s = complement(i-1);
		}
		
		return s;
	}
	
	/**
	 * 原码
	 * @param i
	 * @return
	 */
	public String raw(int i){
		if(i<0){
			i = 0x80000000 | -i;
		}else{
			String s = Integer.toBinaryString(i);
			StringBuilder builder = new StringBuilder();
			for (int j = 0; j < (32 - s.length()); j++) {
				builder.append("0");
			}
			return builder.append(s).toString();
		}
		return Integer.toBinaryString(i);
	}
	
	public String rightUnSign(int num, int step){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < step; i++) {
			sb.append("0");
		}
		return sb.append(complement(num).substring(step)).toString();
	}
	
	@Test
	public void minus(){
		System.out.println(raw(10));
		System.out.println(raw(-10));
		System.out.println(minus(-10));
		System.out.println(complement(-10));
		System.out.println(rightUnSign(-10, 3));
//		System.out.println(complement(10));
	}
	
	@Test
	public void bit(){
		for (int n = 0; n < 10000; n++) {
			int k = 3;
			int y = 1<<k;
			System.out.print(n);
			System.out.print("\t" +n%y);
			System.out.print(":"+(n&(y-1)));
			System.out.println();
		}
	}
	
}
