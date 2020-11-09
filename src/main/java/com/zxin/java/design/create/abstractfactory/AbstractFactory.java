package com.zxin.java.design.create.abstractfactory;

/**
 * 抽象工厂
 */
public interface AbstractFactory {

    /**
     * 创建Phone
     * @return
     */
    Phone createPhone();

    /**
     * 创建PC
     * @return
     */
    PC createPC();

}


class AppleFactory implements AbstractFactory {
    @Override
    public Phone createPhone() {
        return new IPhone();
    }

    @Override
    public PC createPC() {
        return new MacBook();
    }

}

class HuaWeiFactory implements AbstractFactory {
    @Override
    public Phone createPhone() {
        return new MatePhone();
    }

    @Override
    public PC createPC() {
        return new MateBook();
    }
}
