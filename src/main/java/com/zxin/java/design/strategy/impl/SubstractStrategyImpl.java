package com.zxin.java.design.strategy.impl;

import com.zxin.java.design.strategy.inter.IArithmeticStrategy;
import org.springframework.stereotype.Service;

/**
 * @author ZHANGXIN130
 */
@Service("substract")
public class SubstractStrategyImpl implements IArithmeticStrategy {
    @Override
    public int execute(int a, int b) {
        return a - b;
    }
}
