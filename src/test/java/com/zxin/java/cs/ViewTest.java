package com.zxin.java.cs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zxin
 */
public class ViewTest {

    public static void main(String[] args) {
        View view = new View();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(() -> {
            view.setO(new Integer(1));
        });

        executorService.execute(()->{
            Object o = view.getO();
            System.out.println(o);
        });
    }
}
