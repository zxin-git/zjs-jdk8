package com.zxin.java.jdk.jdk8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * @author zxin
 */
public class OptionalTest {

    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        list.add("1");
        List<List<String>> listList = new ArrayList<>();
        listList.add(list);
        Optional optional = Optional.of(list);
        Optional.ofNullable(list);
        optional.ifPresent(System.out::println);
        Optional.ofNullable(listList).map(lists -> lists.get(0)).map(l -> l.get(0)).ifPresent(System.out::println);
        Optional.ofNullable(listList).map(lists -> lists.get(0)).map(l -> l.get(1)).orElse("no");
        Optional.ofNullable(listList).map(lists -> lists.get(0)).map(l -> l.get(1)).orElseGet(this.getClass()::getName);


        Optional.of("a").filter(String::isEmpty).map(s -> s.toUpperCase()).flatMap(s -> Optional.of(s + "flat")).orElse("222");
        Optional.ofNullable("1").orElseGet( ()-> "222222");
        Optional.empty().orElseThrow(()-> new RuntimeException("1"));
    }
}

