package com.zxin.java.design.strategy.impl;

import com.zxin.java.design.strategy.inter.IArithmeticStrategy;
import org.springframework.stereotype.Service;

/**
 * @author ZHANGXIN130
 */
@Service("add")
public class AddStrategyImpl implements IArithmeticStrategy {

    @Override
    public int execute(int a, int b) {
        return a + b;
    }
}
