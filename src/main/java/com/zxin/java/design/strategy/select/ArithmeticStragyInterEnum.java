package com.zxin.java.design.strategy.select;

import com.zxin.java.design.strategy.impl.AddStrategyImpl;
import com.zxin.java.design.strategy.impl.DivideStrategyImpl;
import com.zxin.java.design.strategy.impl.MultiplyStrategyImpl;
import com.zxin.java.design.strategy.impl.SubstractStrategyImpl;
import com.zxin.java.design.strategy.inter.IArithmeticStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 策略实现枚举类
 * @author ZHANGXIN130
 */
@Getter
@AllArgsConstructor
public enum ArithmeticStragyInterEnum {

    ADD("add", AddStrategyImpl.class),
    MULTIPLY("multiply", MultiplyStrategyImpl.class),
    DIVIDE("divide", DivideStrategyImpl.class),
    SUBSTRACT("substract", SubstractStrategyImpl.class),

    ;
    private final String code;

    private final Class<? extends IArithmeticStrategy> strategyClass;

    public static final ArithmeticStragyInterEnum codeOf(String code){
        ArithmeticStragyInterEnum result =  CODE_MAP.get(code);
        if (result != null)
            return result;
        if (code == null)
            throw new NullPointerException("Code is null");
        throw new IllegalArgumentException(
                "No enum constant " + ArithmeticStragyInterEnum.class.getCanonicalName() + "." + code);
    }

    private static final Map<String, ArithmeticStragyInterEnum> CODE_MAP;

    static {
        // 没必要Concurrent
        CODE_MAP = Stream.of(values()).collect(Collectors.toConcurrentMap(strategyEnum -> strategyEnum.getCode() , stragyEnum -> stragyEnum));
    }
}
