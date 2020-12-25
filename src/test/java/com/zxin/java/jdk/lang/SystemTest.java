package com.zxin.java.jdk.lang;

import lombok.extern.slf4j.Slf4j;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryManagerMXBean;
import java.lang.management.MemoryPoolMXBean;
import java.util.Arrays;
import java.util.List;

/**
 * @author zxin
 */
@Slf4j
public class SystemTest {

    public static void main(String[] args) {
        System.out.println(System.getProperties());
        System.out.println(System.getProperty("sun.boot.class.path"));

        menoryStatus();

        System.currentTimeMillis();

        System.exit(2);
    }

    public static void menoryStatus(){
        System.out.println("================内存状态===========================");
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        //获取堆内存使用情况，包括初始大小，最大大小，已使用大小等，单位字节
        System.out.println(memoryMXBean.getHeapMemoryUsage().toString());
        //获取堆外内存使用情况。
        System.out.println(memoryMXBean.getNonHeapMemoryUsage().toString());

        System.out.println("================堆内存状态======================");
        //这里会返回老年代，新生代等内存区的使用情况，按需自取就好
        List<MemoryPoolMXBean> memoryPoolMXBeans = ManagementFactory.getMemoryPoolMXBeans();
        memoryPoolMXBeans.forEach((pool) -> {
            System.out.println(pool.getName());
            System.out.println(pool.getUsage());
        });

        List<MemoryManagerMXBean> list = ManagementFactory.getMemoryManagerMXBeans();
        list.forEach((bean) ->{
            log.info(bean.getName());
            log.info(Arrays.toString(bean.getMemoryPoolNames()));
        });
    }


}
