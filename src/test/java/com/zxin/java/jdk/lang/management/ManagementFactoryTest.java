package com.zxin.java.jdk.lang.management;

import org.junit.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * @author zxin
 */
public class ManagementFactoryTest {

    @Test
    public void test(){
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        System.out.println(runtimeMXBean.getName());
    }

}
