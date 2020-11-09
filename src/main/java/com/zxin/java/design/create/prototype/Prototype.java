package com.zxin.java.design.create.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zxin
 */
@Data
@AllArgsConstructor
public class Prototype implements Cloneable {

    private String name;

    public Object clone() {
        return new Prototype(this.name);
    }

//    public Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }
}
