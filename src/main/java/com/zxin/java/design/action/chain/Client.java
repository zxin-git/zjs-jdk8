package com.zxin.java.design.action.chain;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zxin
 */
public class Client {

    public static void main(String[] args) {
        Chain chain = new Chain(new LogHandler());
        chain.next(new MonitorHandler());
        chain.doHandle();
    }

}
