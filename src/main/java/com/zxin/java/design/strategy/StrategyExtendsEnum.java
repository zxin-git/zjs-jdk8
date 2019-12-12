package com.zxin.java.design.strategy;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ZHANGXIN130
 */
@Getter
@AllArgsConstructor
public enum StrategyExtendsEnum {
    ADD("add"){
        @Override
        public int execute(int a, int b) {
            return a + b;
        }
    },
    ;

    private final String code;

    public abstract int execute(int a, int b);
}
