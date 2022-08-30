package com.zxin.java.jdk.lang;

import org.junit.Test;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

/**
 * @author zxin
 */
public class EnumCollectionTest {

    @Test
    public void enumMap(){
        Map map = new EnumMap(DayOfWeek.class);
    }

    /**
     * RegularEnumSet <= 64
     * JumboEnumSet  >64
     */
    @Test
    public void enumSet(){
        EnumSet.allOf(DayOfWeek.class);
        EnumSet.noneOf(DayOfWeek.class);
    }



}
