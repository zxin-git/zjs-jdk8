package com.zxin.java.design.action.chain;

/**
 * @author zxin
 */
public interface Handler {

    void handle();

}

class LogHandler implements Handler{

    @Override
    public void handle() {

    }
}

class MonitorHandler implements Handler{

    @Override
    public void handle() {

    }
}