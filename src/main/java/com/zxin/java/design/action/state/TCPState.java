package com.zxin.java.design.action.state;

/**
 * 状态接口
 */
public interface TCPState {

    void action();

}

class TCPListen implements TCPState {

    @Override
    public void action() {

    }
}

class TCPEstablish implements TCPState{

    @Override
    public void action() {

    }
}
