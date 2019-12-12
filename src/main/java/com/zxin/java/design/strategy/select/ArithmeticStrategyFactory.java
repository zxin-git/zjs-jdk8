package com.zxin.java.design.strategy.select;

import com.zxin.java.design.strategy.impl.AddStrategyImpl;
import com.zxin.java.design.strategy.impl.DivideStrategyImpl;
import com.zxin.java.design.strategy.impl.MultiplyStrategyImpl;
import com.zxin.java.design.strategy.impl.SubstractStrategyImpl;
import com.zxin.java.design.strategy.inter.IArithmeticStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * 工厂方法的方式
 * @author ZHANGXIN130
 */
public class ArithmeticStrategyFactory {

    private static final Map<String, IArithmeticStrategy> MAP = new HashMap<>();

    static {
        MAP.put("add", new AddStrategyImpl());
        MAP.put("multiply", new MultiplyStrategyImpl());
        MAP.put("divide", new DivideStrategyImpl());
        MAP.put("substract", new SubstractStrategyImpl());
    }

    public static IArithmeticStrategy select(String code){
       return MAP.get(code);
    }

}
