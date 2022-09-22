package com.zxin.java.jdk.lang;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 反射
 * @author zxin
 */
public class ReflectTest {


    @Test
    public void type(){
        List<String> list = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
        Class<? extends List> clazz = list.getClass();
        System.out.println(clazz);
        Class clazz1 = list.getClass();
        System.out.println(clazz1);
    }

}
