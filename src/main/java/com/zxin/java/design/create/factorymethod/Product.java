package com.zxin.java.design.create.factorymethod;

/**
 * 产品对象接口
 * @author zxin
 */
public interface Product {

    void action();

}

class ThriftProduct implements Product {
    @Override
    public void action() {

    }
}

class HttpProduct implements Product {
    @Override
    public void action() {

    }
}
