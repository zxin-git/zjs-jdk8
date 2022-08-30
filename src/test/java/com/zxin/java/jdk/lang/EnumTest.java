package com.zxin.java.jdk.lang;

import org.junit.Test;

import java.time.DayOfWeek;
import java.util.Arrays;

/**
 * @author zxin
 */
public class EnumTest {

    @Test
    public void method(){

        System.out.println(DayOfWeek.SATURDAY.ordinal());
        System.out.println(DayOfWeek.SATURDAY.name());
        System.out.println(DayOfWeek.SATURDAY.toString());

        System.out.println(DayOfWeek.valueOf("SATURDAY"));
        System.out.println(Arrays.toString(DayOfWeek.values()));

    }
}
