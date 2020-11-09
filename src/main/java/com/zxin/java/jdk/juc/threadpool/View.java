package com.zxin.java.jdk.juc.threadpool;

/**
 * @author zxin
 */
public class View {
    private volatile int i;

    public synchronized void setI(int i) {
        this.i = i;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getI() {
        return i;
    }
}
