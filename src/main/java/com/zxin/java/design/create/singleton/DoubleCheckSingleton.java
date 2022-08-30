package com.zxin.java.design.create.singleton;

/**
 * 双重校验锁
 * <ol>
 * 	<li>构造器私有</li>
 * 	<li>静态实例变量，且volatile</li>
 * 	<li>锁类或静态常量</li>
 * 	<li>双重校验判断</li>
 * </ol>
 *
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
