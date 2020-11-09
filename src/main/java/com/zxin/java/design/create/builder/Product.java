package com.zxin.java.design.create.builder;

import lombok.Builder;

/**
 * 产品
 * @author zxin
 */
public class Product {

    /**
     * 产品名称
     */
    private String name;

    /**
     * 产品大小
     */
    private int size;

    /**
     * 产品重量
     */
    private int weight;

    public Product(String name, int size, int weight) {
        this.name = name;
        this.size = size;
        this.weight = weight;
    }

}

