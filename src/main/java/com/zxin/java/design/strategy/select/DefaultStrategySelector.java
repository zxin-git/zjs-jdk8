package com.zxin.java.design.strategy.select;

import com.zxin.java.design.strategy.inter.IArithmeticStrategy;
import com.zxin.java.design.strategy.inter.IStrategySelector;
import org.springframework.stereotype.Component;

/**
 * @author ZHANGXIN130
 */
@Component
public class DefaultStrategySelector implements IStrategySelector {

    @Override
    public IArithmeticStrategy select(String code) {
        try {
            return ArithmeticStragyInterEnum.codeOf("add").getStrategyClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return ArithmeticStrategyFactory.select(code);
    }
}
