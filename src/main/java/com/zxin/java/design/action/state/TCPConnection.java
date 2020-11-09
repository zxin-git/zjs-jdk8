package com.zxin.java.design.action.state;

/**
 *
 * Content对象
 * @author zxin
 */
public class TCPConnection {

    TCPState tcpState;

    public void action(){
        tcpState.action();
    }

}
