package com.zxin.java.design.strategy.select;

import com.zxin.java.design.strategy.SpringUtil;
import com.zxin.java.design.strategy.inter.IArithmeticStrategy;
import com.zxin.java.design.strategy.inter.IStrategySelector;
import org.springframework.stereotype.Component;

/**
 * @author ZHANGXIN130
 */
@Component
public class SpringStrategySelector implements IStrategySelector {

    @Override
    public IArithmeticStrategy select(String code) {
        return SpringUtil.getBean(code, IArithmeticStrategy.class);
    }
}
