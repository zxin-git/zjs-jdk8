package com.zxin.java.jdk.util;

import org.junit.Test;

/**
 * @author zxin
 */
public class EnvTest {
    @Test
    public void env() {
        System.getenv().entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        });
    }

    @Test
    public void properties() {
        System.getProperties().entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        });
    }
}
