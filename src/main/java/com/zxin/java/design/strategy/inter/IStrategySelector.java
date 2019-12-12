package com.zxin.java.design.strategy.inter;

/**
 * 策略选择器接口
 *
 */
public interface IStrategySelector {

    /**
     * 根据code获取策略类
     * @param code
     * @return
     */
    IArithmeticStrategy select(String code);

}
