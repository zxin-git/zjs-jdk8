package com.zxin.java.design.strategy;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.BiFunction;

@Getter
@AllArgsConstructor
public enum ConditionStrategyEnum {

    A((agentType, discountType) -> "", (baseCode, discountRate) -> baseCode * discountRate),
    B((agentType, discountType) -> "", (baseCode, discountRate) -> {throw new RuntimeException();}),
    ;
    private final BiFunction<String, String, String> condition;

    private final BiFunction<Integer, Integer, Integer> strategy;

    public static ConditionStrategyEnum to(String agentType, String discountType){

        return A;
    }
}
