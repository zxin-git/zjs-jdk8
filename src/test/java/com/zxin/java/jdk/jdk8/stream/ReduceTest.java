package com.zxin.java.jdk.jdk8.stream;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * @author zxin
 */
public class ReduceTest {

    @Test
    public void reduce1(){
        Stream<Integer> is = Stream.of(1, 2, 3, 4, 5);
        int sum = is.reduce(0, (s, i) -> s + i);
//        int sum = is.reduce(0, (s, i) -> i = s+i);
//        int sum = is.reduce(0, (s, i) -> {s+=i; return i;});
        System.out.println(sum);

    }
}
