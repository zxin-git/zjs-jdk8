package com.zxin.java.design.create.factorymethod;

/**
 * 工厂方法
 */
public interface Factory {

    Product create();

}

class HttpFactory implements Factory {
    @Override
    public Product create() {
        return new HttpProduct();
    }
}


class ThriftFactory implements Factory {

    @Override
    public Product create() {
        return new ThriftProduct();
    }
}