package com.zxin.java.design.strategy;

/**
 * @author ZHANGXIN130
 */
public class PrimitiveStrategyDemo {

    public int calculate(int a, int b, String operator) {
        int result = Integer.MIN_VALUE;
        if ("add".equals(operator)) {
            result = a + b;
        } else if ("multiply".equals(operator)) {
            result = a * b;
        } else if ("divide".equals(operator)) {
            result = a / b;
        } else if ("subtract".equals(operator)) {
            result = a - b;
        } else if ("modulo".equals(operator)) {
            result = a % b;
        }
        return result;
    }

}
