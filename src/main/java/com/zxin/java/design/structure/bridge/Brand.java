package com.zxin.java.design.structure.bridge;

/**
 * 品牌
 * 实例化接口（implementor）
 * @author zxin
 */
public interface Brand {
    String getBrand();
}

/**
 * 耐克
 */
class Nike implements Brand {

    @Override
    public String getBrand() {
        return "Nike";
    }
}


class LV implements Brand {

    @Override
    public String getBrand() {
        return "LV";
    }
}
