package com.zxin.java.design.strategy;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 利用方法接口属性，Lambda,
 * @author ZHANGXIN130
 */
@AllArgsConstructor
@Getter
public enum StrategyFunctionEnum {

    ADD("add", (a, b) -> a + b),
    MULTIPLY("multiply", (a, b) -> a * b),

    ;

    private final String code;

    private final BiFunction<Integer, Integer, Integer> biFunction;

    public static final StrategyFunctionEnum codeOf(String code){
        return CODE_MAP.get(code);
    }


    /**
     * 必须私有
     */
    private static final Map<String, StrategyFunctionEnum> CODE_MAP;

    static {
        Map<String, StrategyFunctionEnum> map = Stream.of(values())
                .collect(Collectors.toMap(strategyFunctionEnum -> strategyFunctionEnum.getCode() , UnaryOperator.identity()));

        CODE_MAP = Collections.unmodifiableMap(map);
    }
}
