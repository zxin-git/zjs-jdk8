package com.zxin.java.design.create.singleton;

/**
 * 双重校验锁
 * @author zxin
 */
public class DoubleCheckSingleton {

    private DoubleCheckSingleton(){}

    private static volatile DoubleCheckSingleton instance;

    public static DoubleCheckSingleton getInstance(){
        if(instance == null){
            synchronized (DoubleCheckSingleton.class){
                if (instance == null){
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
