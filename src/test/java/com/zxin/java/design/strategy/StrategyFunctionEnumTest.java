package com.zxin.java.design.strategy;

import org.junit.Test;

import static org.junit.Assert.*;

public class StrategyFunctionEnumTest {

    @Test
    public void codeOf() {
        int result = StrategyFunctionEnum.codeOf("add").getBiFunction().apply(10,2);
        System.out.println(result);
    }
}