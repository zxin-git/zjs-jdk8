package com.zxin.java.design.action.visitor;

/**
 * @author zxin
 */
public interface Element {

    void accept(Visitor v);

}

/**
 * ConcreteElement
 */
class KeyWord implements Element{

    @Override
    public void accept(Visitor v) {

    }
}

class Mouse implements Element{

    @Override
    public void accept(Visitor v) {

    }
}