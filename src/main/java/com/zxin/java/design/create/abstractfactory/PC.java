package com.zxin.java.design.create.abstractfactory;

public interface PC {

    /**
     * 办公
     * @return
     */
    void work();
}

class MateBook implements PC{

    @Override
    public void work() {
    }
}

class MacBook implements PC{

    @Override
    public void work() {

    }
}