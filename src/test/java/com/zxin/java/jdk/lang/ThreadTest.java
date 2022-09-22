package com.zxin.java.jdk.lang;

import org.junit.Test;

/**
 * @author zxin
 */
public class ThreadTest {

    @Test
    public void testStack(){
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        System.out.println(stackTraceElements[0]);
    }

}
