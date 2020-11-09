package com.zxin.java.design.structure.bridge;

/**
 * 抽象化角色（Abstraction）
 * @author zxin
 */
public class Bag {

    private Color color;

    private Brand brand;


    public String getBrand() {
        return brand.getBrand();
    }

    public String getColor(){
        return color.getColor();
    }
}
