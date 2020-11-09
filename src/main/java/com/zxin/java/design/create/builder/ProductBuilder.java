package com.zxin.java.design.create.builder;

/**
 * @author zxin
 */
public class ProductBuilder {

    private String name;
    private int size;
    private int weight;

    public ProductBuilder name(String name) { this.name = name; return this; }
    public ProductBuilder size(int size) { this.size = size; return this; }
    public ProductBuilder weight(int weight) { this.weight = weight; return this; }
    public Product build() { return new Product(this.name, this.size, this.weight); }
}
