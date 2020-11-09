package com.zxin.java.design.action.visitor;

public interface Visitor {

    void visit(KeyWord keyWord);

    void visit(Mouse mouse);

}

/**
 * ConcreteVisitor
 */
class DisplayVisitor implements Visitor{

    @Override
    public void visit(KeyWord keyWord) {
        System.out.println("Display keyword");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("Display mouse");
    }
}

class PressVisitor implements Visitor{

    @Override
    public void visit(KeyWord keyWord) {

    }

    @Override
    public void visit(Mouse mouse) {

    }
}
