package com.zxin.java.jdk.lang;

import org.junit.Test;

import java.util.UUID;

/**
 * @author zxin
 */
public class StringTest {
    
    @Test
    public void format(){
//        String a = String.format("aaa", null);
//        System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
        
        String date = String.format("%d-%02d", 2023, 11);
        System.out.println(date);
    }
    
    
    
}
