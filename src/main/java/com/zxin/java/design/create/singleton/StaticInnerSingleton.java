package com.zxin.java.design.create.singleton;

/**
 * 静态内部类
 * @author zxin
 */
public class StaticInnerSingleton {

    private StaticInnerSingleton(){}

    public static StaticInnerSingleton getInstance(){
        return InnerHolder.INSTANCE;
    }

    private static class InnerHolder {
        private static final StaticInnerSingleton INSTANCE = new StaticInnerSingleton();
    }
}
