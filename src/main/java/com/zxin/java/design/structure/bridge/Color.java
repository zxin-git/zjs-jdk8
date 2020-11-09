package com.zxin.java.design.structure.bridge;

/**
 * 实例化接口（Implementor）
 */
public interface Color {
    String getColor();
}

class Red implements Color{

    @Override
    public String getColor() {
        return "Red";
    }
}

class Yellow implements Color{

    @Override
    public String getColor() {
        return "Yellow";
    }
}
