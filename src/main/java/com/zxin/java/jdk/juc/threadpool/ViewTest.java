package com.zxin.java.jdk.juc.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zxin
 */
public class ViewTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        View view = new View();
        AtomicInteger counter = new AtomicInteger(0);
        for (int i = 0; i < 10; i++) {
            executorService.execute(()->{
                System.out.println(counter.get());
                view.setI(counter.getAndIncrement());
            });
        }
        for (int i = 0; i < 10; i++) {
            executorService.execute(()->{
                System.out.println(view.getI());
            });
        }
    }
}
